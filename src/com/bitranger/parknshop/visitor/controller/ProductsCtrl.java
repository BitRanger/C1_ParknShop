package com.bitranger.parknshop.visitor.controller;

import java.text.AttributedCharacterIterator.Attribute;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.buyer.controller.Utility;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ItemFinderService;
import com.bitranger.parknshop.common.service.ads.AdCenter;
import com.bitranger.parknshop.visitor.view.VisitorParams;
import com.bitranger.parknshop.visitor.view.VisitorView;



@Controller
public class ProductsCtrl {

	@Autowired
	private ItemFinderService itemFinderService;
	

	@Autowired
	IPsItemDAO psItemDAO;
	
	@Autowired
	AdCenter adCenter;
	
	@RequestMapping(value=VisitorView.itemCtrlMapping, method=RequestMethod.GET)
	public ModelAndView product(HttpServletRequest request, HttpServletResponse response){
		
		List<PsItem> itemList = itemFinderService.getItems(request);
System.out.println("ProductsCtrl.product()");
System.out.println(itemList);
		for(PsItem psItem : itemList)
		{
			psItem.setIntroduction(Utility.slice(psItem.getIntroduction(), 40));
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject(VisitorParams.productItemList, itemList);
		mv.addObject(VisitorParams.itemCount, itemList.size());
		mv.setViewName(VisitorView.product);
		
		
		List<PsPromotItem> ads = adCenter.itemAdService.forItemList(itemList, 60, null);
		mv.addObject("ad_list", ads);
		
		return mv;
		
	}
}
