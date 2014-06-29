package com.bitranger.parknshop.buyer.controller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.model.PsCategory;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ads.AdCenter;

/**
 * @author Yu Bowen
 * This is a controller for preparing for data used in indexView.jsp 
 **************** List of Req Attributes *********************
 *  psIndexDisplay: HashMap<Integer, List<PsItem>> indicating first ten items for each
 *  	category
 *********************************************************
 *
 **************** List of Session Attributes *********************
 * 	psCategories: List<PsCategory> indicating all the categories
 *********************************************************
 */
@Controller
public class IndexController {
	@Autowired
	private IPsCategoryDAO psCategoryDao;
	
	@Autowired
	private IPsItemDAO psItemDao;
	
	@Autowired
	AdCenter adCenter;
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
		List<PsCategory> psCategories = psCategoryDao.findAll();
		req.getSession().setAttribute("psCategories", psCategories);
		HashMap<Integer, List<PsItem>> psIndexDisplay = new HashMap<>();
		for(PsCategory cate : psCategories)
		{
			FetchOption op = new FetchOption();
			op.limit=5;
			op.offset=0;
			op.sortOption = SortOption.DESCENDING;
			psIndexDisplay.put(cate.getId(), psItemDao.findByCountPurchaseInCategory(cate.getId(), op));
		}
		FetchOption option = new FetchOption();
		option.limit=15;
		option.offset=0;
		option.ascending();
		List<PsItem> psItems = psItemDao.findByCountFavourite(option);
		req.setAttribute("psIndexDisplay", psIndexDisplay);
		req.setAttribute("psItems", psItems);
		
		req.setAttribute("ad_list", adCenter.itemAdService.forIndexPage(60));
		
		return "indexView";
	}
}
