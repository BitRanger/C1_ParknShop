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
package com.bitranger.parknshop.common.view.taglib;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
 * @author BowenCai
 *
 */
public abstract class WriterTag extends SimpleTagSupport {

	/**
	 * compiler flag
	 */
	protected static final boolean TEST_MODE = false;
	
	protected Logger LOG = Logger.getLogger(WriterTag.class.getName());

	public static final String SUCCESS = "SUCCESS;"
			+ "Do not try to return your own 'SUCCESS', it will fail 'str == str' and be treated as error"; // success return
	
//	protected NativePackage getNatives() {
//		NativePackage pkg = (NativePackage) 
//					getJspContext().getAttribute(NativePackage.NAME, 
//							PageContext.SESSION_SCOPE);
//		if (pkg == null) {// unlikely
//			pkg = (NativePackage) getJspContext().getAttribute(NativePackage.NAME, 
//					PageContext.REQUEST_SCOPE);
//			LOG.log(Level.WARNING, "cannot get localProperties from session, try get from request");
//		}
//		if (pkg == null) {//unlikely
//			WebI18nService service = AppContext.beanAssembler.getBean("i18nService");
//			if (service != null) {
//				pkg = service.getDefaultPkg();
//				LOG.log(Level.SEVERE, "cannot get localProperties from session or request, using default");
//			} else {
//				LOG.log(Level.SEVERE, "cannot get localProperties from session or request, null i18nService");
//			}
//		}
//		return pkg;
//	}
	
	
	abstract public String write(Writer writer) throws IOException;
	
	@Override
	public void doTag() {
		
		if (!TEST_MODE) {
			try {
				JspWriter writer = getJspContext().getOut();
				String ret = write(writer);
				if (SUCCESS != ret) {
					writer.write("<h1 align=\"center\"><font color=\"red\"> ERROR in tag["
							+ getClass().getSimpleName()
							+ "]  </font> </h1>"
							+ "<br/>\r\nMessage:<pre>\r\n" + ret + "\r\n</pre>");
				}
				
			} catch (Exception e) {
				LOG.log(Level.SEVERE, "error writing jsp", e);
			}
			
		} else {
			PrintWriter writer = new PrintWriter(System.out);
			try {
				String ret = write(writer);
				if (SUCCESS != ret) {
					PrintWriter errWriter = new PrintWriter(System.err);
					errWriter.write("\nError in tag[" + getClass().getSimpleName() + "]\n"
							+"msg[" + ret +"]\n");
					errWriter.flush();
				}
			} catch (Exception e) {
				PrintWriter errWriter = new PrintWriter(System.err);
				errWriter.write("Exception\r\n");
				e.printStackTrace(errWriter);
				errWriter.write("\r\n");
				errWriter.flush();
			}
			writer.flush();
		}
	}
}



