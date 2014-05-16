package com.bitranger.parknshop.visitor.controller;

import java.beans.FeatureDescriptor;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.visitor.VisitorView;


/**
 *@author BowenCai
 *@since 9:29:01 AM
 */
@Controller
public class ItemList {

	@Inject
	PsItemDAO psItemDAO;

	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView name(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView(VisitorView.list);
//		System.out.println(req.getQueryString());
		String[] tags = req.getParameterValues("tag");
		
		/**
		 * extract param
		 */
		
		/**
		 * get data
		 */
		List<PsItem> items = psItemDAO.findByCountFavouriteInCategory(1, FetchOption.newOption()
														.offset(2)
														.limit(4)
														.ascending());
		mv.addObject("item_list", items);
		return mv;
	}
	
	public static Integer name(HttpServletRequest req) {
		return null;
	}

}



