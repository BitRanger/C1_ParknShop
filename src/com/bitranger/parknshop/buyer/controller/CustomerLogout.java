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
package com.bitranger.parknshop.buyer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * @author Yu Bowen
 * Controller for logout
 * Output:
 * 		The user unauthenticated.
 */
@Controller
public class CustomerLogout {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger("primary");
	
	@RequestMapping("/logout")
	public String customerLogout(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		PsCustomer currentCustomer = (PsCustomer) session.getAttribute("currentCustomer");
		PsSeller currentSeller = (PsSeller) session.getAttribute("currentSeller");
		if(currentCustomer != null)
		{
			session.removeAttribute("currentCustomer");
		}
		if(currentSeller != null)
		{
			session.removeAttribute("currentSeller");
		}
		return "redirect:/";
	}
}
