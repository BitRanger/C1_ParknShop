package com.bitranger.parknshop.visitor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.visitor.views.Names;
import com.bitranger.parknshop.visitor.views.URLs;
import com.bitranger.parknshop.visitor.views.VisitorViews;


/**
 *@author BowenCai
 *@since 9:29:06 AM
 */
public class ItemEntity {

	
	@RequestMapping(value=URLs.item_detail)
	public ModelAndView name(HttpServletRequest request, ModelAndView mv) {
		
		PsItemDAO itemDAO = null;
		
		/**
		 * 
		 */
		String idStr = request.getParameter(URLs.params.itemId);
		PsItem item =  itemDAO.findById(Integer.parseInt(idStr));
		mv.setViewName(VisitorViews.itemDetail);
		
		mv.addObject(Names.item, item);
		
		return mv;
	}
}
