package com.bitranger.parknshop.visitor.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ItemFinderService;
import com.bitranger.parknshop.visitor.views.Names;
import com.bitranger.parknshop.visitor.views.VisitorViews;



@Controller
public class ItemCtrl {

	@Autowired
	private ItemFinderService itemFinderService;
	
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView product(HttpServletRequest request, HttpServletResponse response){
		
		
		List<PsItem> itemList = itemFinderService.getItems(request);
					
		ModelAndView mv = new ModelAndView();
		mv.addObject(Names.model.itemList, itemList);
		mv.setViewName(VisitorViews.itemList);
	
		return mv;
		
	}
}
