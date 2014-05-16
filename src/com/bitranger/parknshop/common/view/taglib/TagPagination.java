/*******************************************************************************
 * Copyright (c) 2014 Bowen Cai.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Bowen Cai - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.common.view.taglib;

import java.io.IOException;
import java.io.Writer;

import com.bitranger.parknshop.util.Str;

/*
  <div class="col-lg-8 col-sm-8 col-xs-12 text-center"><!--centerize pagination-->
      <ul class="pagination">
        <li><a href="http://www.caibowen.com/blog/page=0.html">&laquo;</a></li>
        <li><a href="http://www.caibowen.com/blog/page=27.html">27</a></li>
        <li><a href="http://www.caibowen.com/blog/page=28.html">28</a></li>
        <li class="active"><a href="http://www.caibowen.com/blog/page=29.html">29</a></li>
        <li><a href="http://www.caibowen.com/blog/page=30.html">30</a></li>
        <li><a href="http://www.caibowen.com/blog/page=31.html">31</a></li>
        <li><a href="http://www.caibowen.com/blog/page=35.html">&raquo;</a></li>
      </ul>
  </div>
  
  <div class="col-lg-8 col-sm-8 col-xs-12 text-center"><!--centerize pagination-->
   	<bw:pagination current="" total=""/>  
  </div>
  

 * if no 'current page number' and 'total page number ' specified, 
 * pagination shall not be printed
  
*/
/** 
 * @author BowenCai
 *
 */
public class TagPagination extends WriterTag {
	
	/**
	 * start from 0, display from 1
	 */
	String current;
	/**
	 * start from 0, display from 1 
	 */
	String total;
	
	@Override
	public String write(Writer writer) throws IOException {

		if (Str.Utils.notBlank(total) && Str.Utils.notBlank(current)) {
			int cur = Integer.parseInt(current);
			int tol = Integer.parseInt(total);

			writer.write(
			"<ul class=\"pagination pagination-lg\">\n"
			+"\t<li><a data-toggle=\"tooltip\" title=\"");
//			writer.write(pkg.getStr("postList.firstPage"));
			writer.write("\" href=\""); 
//				writer.write(UrlBuilder.post.toPageURL(1));
				writer.write("\">&laquo;</a></li>\n");

			int start = cur - 2;
			int end = cur + 2;
			start = start < 1 ? 1 : start;
			end = end < tol ? end : tol;
			for (int i = start; i <= end; i++) {
				if (i == cur) {
					writer.write("\t<li class=\"active\"><a href=\"");
				} else {
//					writer.write("\t<li><a href=\"");
				}
//				writer.write(UrlBuilder.post.toPageURL(i));
				writer.write("\">");
				writer.write(Integer.toString(i));
				writer.write("</a></li>\n");
			}
			writer.write("\t<li><a data-toggle=\"tooltip\" title=\"");
//			writer.write(pkg.getStr("postList.lastPage"));
			writer.write("\" href=\"");
//				writer.write(UrlBuilder.post.toPageURL(tol));
				
			writer.write("\">&raquo;</a></li>\n"	
						+"</ul>");
			
		}
		return SUCCESS;
	}

//	public static void main(String... a) throws IOException {
//		TagPagination tag = new TagPagination();
//		tag.setTotal("30");
//		tag.setCurrent("22");
//		tag.doTag();
//	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}
}
