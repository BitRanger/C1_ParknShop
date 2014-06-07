package com.bitranger.parknshop.common.controller;

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
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
		List<PsCategory> psCategories = psCategoryDao.findAll();
		req.getSession().setAttribute("psCategories", psCategories);
		HashMap<Integer, List<PsItem>> psIndexDisplay = new HashMap<>();
		for(PsCategory cate : psCategories)
		{
			FetchOption op = new FetchOption();
			op.limit=10;
			op.offset=0;
			op.sortOption = SortOption.DESCENDING;
			psIndexDisplay.put(cate.getId(), psItemDao.findByCountPurchaseInCategory(cate.getId(), op));
		}
		req.setAttribute("psIndexDisplay", psIndexDisplay);
		return "indexView";
	}
}
