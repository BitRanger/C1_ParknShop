package com.bitranger.parknshop.visitor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.dao.IPsItemInfoDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsItemInfo;
import com.bitranger.parknshop.common.service.IPsItemService;

@Controller
public class ItemCtrl {

	@Autowired
	IPsItemService psItemService;
	
	@Autowired 
	IPsItemInfoDAO psItemInfoDAO;
	
	@RequestMapping(value="/item", method=RequestMethod.GET)
	public org.springframework.web.servlet.ModelAndView item(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		Integer itemId = Integer.parseInt(request.getParameter("id"));
		PsItem item = psItemService.findById(itemId);
		List<PsItemInfo> itemInfos = psItemInfoDAO.findByItemId(itemId); 
		
		mv.addObject("item", item);
		mv.addObject("itemInfoList", itemInfos);
		mv.addObject("urlList", splitPicUrl(item.getUrlPicture()));
		
		mv.setViewName("detail");
		
		return mv;
	}
	
	
	/**
	 * split the urlPicture
	 * @param urlPic
	 * @return
	 */
	public List<String> splitPicUrl(String urlPic) {

		List<String> list = Arrays.asList(urlPic.split("@"));
		
		return list;
		
	}
}
