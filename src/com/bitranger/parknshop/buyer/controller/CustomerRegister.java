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

import java.sql.Timestamp;
import java.util.logging.ConsoleHandler;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * @author Yu Bowen
 * Controller for Register
 * Input:
 * 		Parameters for login
 * Output:
 * 		
 */
@Controller
public class CustomerRegister {
	@Autowired
	public IPsCustomerDAO psCustomerDao;
	
	@Autowired
	public IPsSellerDAO psSellerDao;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger("primary");
	
	// TODO method must be POST after debug
	/**
	 * @param req
	 * @param username
	 * @param email
	 * @param password
	 * @param buyer
	 * 	Set not null if the person to register is buyer
	 * @param seller
	 *  Set not null if the person to register is seller
	 * @return
	 */
	@RequestMapping(value="/register")//, method=RequestMethod.POST)
	public String registerCustomer(HttpServletRequest req, 
		 String username, 
		 String email, 
		 String password, 
		 String role)
	{
		if(email==null || password==null || role==null)
			return Utility.error("Param Error.");
		if(role.equals("seller"))
		{
			log.debug("Seller Try to sign up.");
			Timestamp now = new Timestamp(System.currentTimeMillis());
			PsSeller toAdd = new PsSeller(email, password, new Timestamp(System.currentTimeMillis()));
			toAdd.setNickname(username);
			toAdd.setTimeCreated(now);
			psSellerDao.save(toAdd);
			req.getSession().setAttribute("currentSeller", toAdd);
		}
		else if(role.equals("buyer"))
		{
			log.debug("Buyer Try to sign up.");
			Timestamp now = new Timestamp(System.currentTimeMillis());
			PsCustomer toAdd = new PsCustomer(username, email, password, new Short((short)0) , now);
			psCustomerDao.save(toAdd);
			req.getSession().setAttribute("currentCustomer", toAdd);
		}else
		{
			log.debug("Parameter Error.");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/validEmail")
	public @ResponseBody String isEmailExisted(String email)
	{
		PsCustomer customer = psCustomerDao.findByEmail(email);
		if(customer == null)
			return "false";
		else
			return "true";
	}
}
