package com.bitranger.parknshop.visitor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.CommonNames;
import com.bitranger.parknshop.common.dao.IPersistantMap;
import com.bitranger.parknshop.common.fetch.ItemFetch;
import com.bitranger.parknshop.common.fetch.ItemFinder;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ads.AdCenter;
import com.bitranger.parknshop.core.SysConstants;
import com.bitranger.parknshop.visitor.RequestParamSetter;
import com.bitranger.parknshop.visitor.views.Names;
import com.bitranger.parknshop.visitor.views.VisitorViews;



/**
 *@author BowenCai
 *@since 9:14:16 PM
 */
@Controller
public class Index {
	
	@Inject
	AdCenter adCenter;
	
	@Inject
	IPersistantMap persistantMap;
	
	@Inject
	ItemFinder finder;
	
//						/abc/dev/category=2/tag=taggg
	@RequestMapping(value="/abc/dev/category={data::int}/", 
					method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse httpServletResponse) {

List<PsItem>items = finder.newFind()
						.categoryId(0)
						.tagIDs(1,2,2,3)
						.maxPrice(10.0)
						.minPrice(5.0)
						.orderBy("price").ascending()
						.page(5)
						.list();

request.setAttribute(Names.ItemList, items);

request.setAttribute(CommonNames.Ads.IndexItems, 
		adCenter.itemAdService.forIndexPage());
ArrayList<String> tempVar = new ArrayList<>();

persistantMap.put(SysConstants.tmpVar, tempVar);

RequestParamSetter setter = new RequestParamSetter(request);
ItemFetch fetch = finder.findWith(setter);
items = fetch.list();

		return new ModelAndView(VisitorViews.index);
	}
	
}




