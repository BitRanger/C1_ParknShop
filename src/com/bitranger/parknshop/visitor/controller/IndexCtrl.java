package com.bitranger.parknshop.visitor.controller;

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



/**
 *@author BowenCai
 *@since 9:14:16 PM
 */
@Controller
public class IndexCtrl {

	@Autowired
	@Qualifier(value="psTagDao")
	IPsTagDAO psTagDao;
	
	@Autowired
	@Qualifier(value="psCategoryDao")
	IPsCategoryDAO categoryDao;
	
	@Autowired
	@Qualifier(value="psItemDao")
	IPsItemDAO psItemDao;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,
								HttpServletResponse response) {
		
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
