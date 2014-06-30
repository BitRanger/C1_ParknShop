/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.util;

import java.util.Locale;
import java.util.regex.Pattern;

import javax.annotation.Nullable;


/**
 * 
 * @author BowenCai
 *
 */
public class Str {
	
	public static class Patterns{

		public static final Pattern POST_URI_TITLE = Pattern.compile(
				"^[A-Za-z0-9_.-]{3,200}$");

		public static final Pattern ENTITY_FIELD_NAME = Pattern.compile(
				"^[A-Za-z][A-Za-z0-9_]{3,500}$");
	
		public static final Pattern URL = Pattern.compile(
				"^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
				Pattern.CASE_INSENSITIVE);

		public static final Pattern ASCII = Pattern.compile("\\A\\p{ASCII}*\\z");
		
		/**
		 * mapping URL must from the root(leading with '/')
		 */
		public static final Pattern MAPPING_URI = Pattern.compile(
				"^/([\\w\\-\\./_=]){0,64}\\*?$", Pattern.CASE_INSENSITIVE);

		public static final Pattern COOKIE_NAME = Pattern.compile(
			"^(([\\w\\-]+|\\{([a-zA-Z][\\w]*)\\})(;*)/?)+(\\.\\w+$)?|^/$");
		
		/**
		 * from Struts2
		 */
		public static final Pattern EMAIL = Pattern.compile(
				"\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*"
				+"@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b"
		);

		public static void main(String...a) {
			System.out.println(EMAIL.matcher("hzzyxxx@163.com").matches());
		}
		
		public static final Pattern INTERGER = Pattern.compile("(-?[0-9]*)");
		
		public static final Pattern FLOAT_NUMBER = Pattern.compile(
				"(([1-9][0-9]*\\.?[0-9]*)|(\\.[0-9]+))([Ee][+-]?[0-9]+)?");

		private Patterns(){}
	}

//	public static void main(String[] args) {
//		System.out.println(Patterns.INTERGER.matcher(null).matches());
//	}
	
	public static class Utils {
	
		/**
		 * String will be trimmed
		 * @param s
		 * @return s != null && s.trim().length() > 0;
		 */
		public static boolean notBlank(final String s) {
			if (s != null) {
				
				int right = s.length();
				int left = 0;
				while (left < right && s.charAt(left) <= ' ') {
					left++;
				}
				while (left < right && s.charAt(right - 1) <= ' ') {
					right--;
				}
				return left != right;
			}
			return false;
 		}
		
	    public static Locale parseLocale(String str) {
	        if (str == null) {
	            return null;
	        }
	        if (str.contains("#")) { // LANG-879 - Cannot handle Java 7 script & extensions
	        	return null;
	        }
	        final int len = str.length();
	        if (len < 2) {
	        	return null;
	        }
	        final char ch0 = str.charAt(0);
	        if (ch0 == '_') {
	            if (len < 3) {
	            	return null;
	            }
	            final char ch1 = str.charAt(1);
	            final char ch2 = str.charAt(2);
	            if (!Character.isUpperCase(ch1) || !Character.isUpperCase(ch2)) {
	            	return null;
	            }
	            if (len == 3) {
	            	return null;
	            }
	            if (len < 5) {
	            	return null;
	            }
	            if (str.charAt(3) != '_') {
	            	return null;
	            }
	            return new Locale("", str.substring(1, 3), str.substring(4));
	        }
	        final char ch1 = str.charAt(1);
	        if (!Character.isLowerCase(ch0) || !Character.isLowerCase(ch1)) {
	        	return null;
	        }
	        if (len == 2) {
	            return new Locale(str);
	        }
	        if (len < 5) {
	        	return null;
	        }
	        if (str.charAt(2) != '_') {
	        	return null;
	        }
	        final char ch3 = str.charAt(3);
	        if (ch3 == '_') {
	            return new Locale(str.substring(0, 2), "", str.substring(4));
	        }
	        final char ch4 = str.charAt(4);
	        if (!Character.isUpperCase(ch3) || !Character.isUpperCase(ch4)) {
	        	return null;
	        }
	        if (len == 5) {
	            return new Locale(str.substring(0, 2), str.substring(3, 5));
	        }
	        if (len < 7) {
	        	return null;
	        }
	        if (str.charAt(5) != '_') {
	        	return null;
	        }
	        return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
	    }
	    
		public static final boolean isEmail(final String email) {
			return Patterns.EMAIL.matcher(email).matches();
		}
	    /**
	     * 
	     * @param acceptedLang 'zh_CN' 'en'
	     * @return
	     */
	    @Nullable
		public static Locale fastParseLocale(String acceptedLang) {
	    	Assert.notBlank(acceptedLang);
			acceptedLang = acceptedLang.trim();
			
			if (acceptedLang.startsWith("zh")
					|| acceptedLang.startsWith("ZH")) {

				if (acceptedLang.length() > 4) {
					char c2 = acceptedLang.charAt(2);
					char c3 = acceptedLang.charAt(3);
					if ((c2 == '-') // zh-TW or zh-HK
						&& ( (c3 == 'T' || c3 == 't') 
							|| (c3 == 'H' || c3 == 'h')) ) {

						return Locale.TRADITIONAL_CHINESE;
					}
				}
				return Locale.SIMPLIFIED_CHINESE;
				
			} else if (acceptedLang.startsWith("en")
						|| acceptedLang.startsWith("EN")) {
				return Locale.ENGLISH;
				
			}  else {
				return null;
			}
		}
		
		public static final long ipV4ToLong(final String ipAddress) {
			long result = 0;
			String[] atoms = ipAddress.split("\\.");

			for (int i = 3; i >= 0; i--) {
				result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
			}
			return result & 0xFFFFFFFF;
		}

		public static final String longToIpV4(long ip) {
			StringBuilder sb = new StringBuilder(15);

			for (int i = 0; i < 4; i++) {
				sb.insert(0, Long.toString(ip & 0xff));

				if (i < 3) {
					sb.insert(0, '.');
				}
				ip >>= 8;
			}

			return sb.toString();
		}
	}
	
	public static final String quote(final String param) {

		int paraLen = param.length();
		StringBuffer buf = new StringBuffer((int) (paraLen * 6 / 5));
		buf.append('\'');
		//
		// Note: buf.append(char) is _faster_ than
		// appending in blocks, because the block
		// append requires a System.arraycopy()....
		// go figure...

		for (int i = 0; i < paraLen; ++i) {
			char c = param.charAt(i);

			switch (c) {
			// case 0: /* Must be escaped for 'mysql' */
			// buf.append('\\');
			// buf.append('0');
			//
			// break;

			case '\n': /* Must be escaped for logs */
				buf.append('\\');
				buf.append('n');

				break;

			case '\r':
				buf.append('\\');
				buf.append('r');

				break;

			case '\\':
				buf.append('\\');
				buf.append('\\');

				break;

			case '\'':
				buf.append('\\');
				buf.append('\'');

				break;

			// this.usingAnsiMode = !this.connection.useAnsiQuotedIdentifiers();

			case '"': /* Better safe than sorry */
				// if (this.usingAnsiMode) {
				// buf.append('\\');
				// }

				buf.append('"');

				break;

			case '\032': /* This gives problems on Win32 */
				buf.append('\\');
				buf.append('Z');

				break;

			default:
				buf.append(c);
			} // switch
		} // for

		buf.append('\'');
		return buf.toString();
	} // func: quote
	
	private Str(){}

}
