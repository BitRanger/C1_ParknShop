package com.bitranger.parknshop.visitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 *@author BowenCai
 *@since 9:14:16 PM
 */
@Controller
public class IndexCtrl {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		return null;
	}
	
	
}
