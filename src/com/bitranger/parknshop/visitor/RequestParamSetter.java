package com.bitranger.parknshop.visitor;

import javax.servlet.http.HttpServletRequest;

import com.bitranger.parknshop.common.fetch.IFetchParamSetter;
import com.bitranger.parknshop.common.fetch.ItemFetch;
import com.bitranger.parknshop.util.Converter;
import com.bitranger.parknshop.util.Str;
import com.bitranger.parknshop.visitor.views.URLs;



/**
 *@author BowenCai
 *@since 8:07:10 PM
 */
public class RequestParamSetter implements IFetchParamSetter{

	private HttpServletRequest request;
	
	public RequestParamSetter(HttpServletRequest request) {
		this.request = request;
	}


	@Override
	public void setParams(ItemFetch oneFetch) {
		String cat = request.getParameter(URLs.categoryId);
			Integer num = Converter.slient.toInteger(cat);
			oneFetch.categoryId(num == null ? 0 : num);
		String[] tags = request.getParameterValues(URLs.tag);
		
	}

}






