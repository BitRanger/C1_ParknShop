package com.bitranger.parknshop.buyer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.model.PsCustomer;

/**
 * @author Yu Bowen
 * Controller for logout
 */
@Controller
public class CustomerLogout {
	@RequestMapping("/logout")
	public String customerLogout(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		PsCustomer current = (PsCustomer) session.getAttribute("currentCustomer");
		if(current != null)
		{
			session.removeAttribute("currentCustomer");
		}
		return "forward:/";
	}
}
