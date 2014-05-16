package com.bitranger.parknshop.visitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.visitor.VisitorView;



/**
 *@author BowenCai
 *@since 9:14:16 PM
 */
@Controller
public class IndexCtrl {
//						/abc/dev/category=2/tag=taggg
	@RequestMapping(value="/abc/dev/category={data::int}/", method=RequestMethod.GET)
	public ModelAndView index(Integer i) {
		
		return new ModelAndView(VisitorView.index);
	}
	
}
