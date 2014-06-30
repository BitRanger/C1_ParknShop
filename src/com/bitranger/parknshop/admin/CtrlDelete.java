/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *@author BowenCai
 *@since 8:59:22 PM
 */
@Controller
public class CtrlDelete extends PropHolder {

	
//	@RequestMapping(value="/admin/delete/notice", method=RequestMethod.GET)
//	public ModelAndView name(HttpServletRequest request) {
//
//		String id = request.getParameter("id");
////		Integer i =  Integer.parseInt(id);
//		System.out.println("CtrlDelete.name()");
//		System.out.println(id);
//		
////		psNoticeAdminDAO.delete(psNoticeAdminDAO.findById());
//		return new ModelAndView("admin");
//	}

	
	@RequestMapping(value="/admin/delete/notice/idddd", method=RequestMethod.GET)
	public ModelAndView name221() {
		return new ModelAndView("admin");
	}
//	@RequestMapping(value="/admin/delete/notice/id/{cur_id}", method=RequestMethod.GET)
//	public ModelAndView name1(@PathVariable("cur_id") Integer id) {
//		
////		String id = request.getParameter("id");
////		Integer i =  Integer.parseInt(id);
//		System.out.println("CtrlDelete.name()");
//		System.out.println(id);
//		
////		psNoticeAdminDAO.delete(psNoticeAdminDAO.findById());
//		return new ModelAndView("admin");
//	}
}
