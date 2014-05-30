package com.bitranger.parknshop.visitor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.fetch.ItemFetch;
import com.bitranger.parknshop.common.fetch.ItemFinder;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ItemFinderService;
import com.bitranger.parknshop.visitor.RequestParamSetter;
import com.bitranger.parknshop.visitor.views.Names;
import com.bitranger.parknshop.visitor.views.URLs;
import com.bitranger.parknshop.visitor.views.VisitorViews;


@Controller
public class ItemList {
	
	
	@Inject
	ItemFinder finder;
	
	// product?category_id=23&tag=J
	@RequestMapping(value=URLs.item_list, method=RequestMethod.GET)
	public ModelAndView product(HttpServletRequest request, ModelAndView mv){
		
		
		ItemFinderService itemFinderService = new ItemFinderService();
		
		List<PsItem> itemList =
			itemFinderService.categoryId(request.getParameter(URLs.params.categoryId))
					     	 .tagIds(request.getParameterValues(URLs.params.tag))
					     	 .maxPrice(request.getParameter(URLs.params.maxPrice))
					     	 .minPrice(request.getParameter(URLs.params.minPrice))
					     	 .pageNumber(request.getParameter(URLs.params.pageNumber))
					     	 .orderBy(request.getParameter(URLs.params.orderBy))
					     	 .asd(request.getParameter(URLs.params.asd))
					     	 .list();
		
		mv.setViewName(VisitorViews.itemList);
		
//		
//		ItemFetch fetch = finder.findWith(new RequestParamSetter(request));
//		itemList = fetch.list();
		
		mv.addObject(Names.ItemList, itemList);
		
		return mv;
		
	}
}
