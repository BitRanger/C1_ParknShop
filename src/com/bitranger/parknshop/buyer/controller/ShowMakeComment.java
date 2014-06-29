package com.bitranger.parknshop.buyer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;

@Controller
public class ShowMakeComment {
	
	@Autowired
	PsItemDAO psItemDao;
	
	@RequestMapping("/comment")
	public String showMakeComment(HttpServletRequest req, Integer psItemId)
	{
		PsItem psItem = psItemDao.findById(psItemId);
		req.setAttribute("psItem", psItem);
		return "buyer/buyer_comment";
	}
}
