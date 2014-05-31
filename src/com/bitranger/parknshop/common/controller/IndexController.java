package com.bitranger.parknshop.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.model.PsCategory;

/**
 * @author Yu Bowen
 * Controller for showing index
 */
@Controller
public class IndexController {
	@Autowired
	private IPsCategoryDAO psCategoryDao;
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
		List<PsCategory> psCategories = psCategoryDao.findAll();
		req.setAttribute("psCategories", psCategories);
		
		return "index";
	}
}
