package com.bitranger.parknshop.visitor.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.IPsTagDAO;
import com.bitranger.parknshop.common.service.ads.AdCenter;



/**
 *@author BowenCai
 *@since 9:14:16 PM
 */
@Controller
public class IndexCtrl {

	@Inject
	IPsTagDAO psTagDao;
	
	@Inject
	IPsCategoryDAO categoryDao;
	
	@Inject
	IPsItemDAO psItemDao;
	
	@Autowired
	AdCenter adCenter;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index() {
		adCenter.itemAdService.forIndexPage(10);
//		// get the ads
//		
//		// -------------------------
//		
//		// get the tags
//		List<PsTag> tagList = psTagDao.findAll();
//		
//		// get the categorys
//		List<PsCategory> categoryList = categoryDao.findAll();
//		
//		// get the top 10 of purchase
//		List<PsItem> purchaseItemList = psItemDao.findByCountPurchase(
//												FetchOption
//														.newOption()
//														.offset(0)
//														.limit(10)
//														.descending());
//		
//		// get the top 10 of favorite
//		List<PsItem> favoriteItemList = psItemDao.findByCountFavourite(
//												FetchOption
//														.newOption()
//														.offset(0)
//														.limit(10)
//														.descending());
//		
				
		return new ModelAndView("index");
	}
	
	
}
