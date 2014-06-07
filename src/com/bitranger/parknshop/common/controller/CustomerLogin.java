package com.bitranger.parknshop.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;

/**
 * @author Yu Bowen
 * "/login"
 * Input:
 * 		email, password combination for login
 * Output:
 * 		currentCustomer set if customer log in
 * 		currentSeller	set	if seller	log in
 */
//TODO This login function is non-functioning for seller, Due to LACK for information
@Controller
public class CustomerLogin {
	@Autowired
	private IPsCustomerDAO psCustomerDao;
	
	@RequestMapping("/login")
	public String customerLogin(HttpServletRequest req, String email, String password)
	{
		HttpSession session = req.getSession();
		if(session.getAttribute("currentCustomer") != null)
			return "redirect:/";
		PsCustomer persistCustomer = psCustomerDao.findByEmail(email);
		if(persistCustomer == null || !persistCustomer.getPassword().equals(password))
			return "redirect:/";
		session.setAttribute("currentCustomer", persistCustomer);
		return "redirect:/";
	}
}
