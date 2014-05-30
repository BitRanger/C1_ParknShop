
package com.bitranger.parknshop.common.controller;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;

/**
 * @author Yu Bowen
 * Controller for Register
 */
@Controller
public class CustomerRegister {
	@Autowired
	public IPsCustomerDAO psCustomerDao;
	
	// TODO method must be POST after debug
	@RequestMapping(value="/register")//, method=RequestMethod.POST)
	public String registerCustomer(String username, String email, String password)
	{
		Timestamp now = new Timestamp(System.currentTimeMillis());
		PsCustomer toAdd = new PsCustomer(username, email, password, new Short((short)0) , now);
		psCustomerDao.save(toAdd);
		
		return "redirect:/";
	}
}
