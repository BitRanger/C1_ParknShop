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
package com.bitranger.parknshop.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bitranger.parknshop.seller.dao.impl.PsSellerDAO;
import com.bitranger.parknshop.seller.model.PsSeller;



@Controller
public class SellerChangePasCtrl {

	@Autowired
	@Qualifier(value="psSellerDao")
	PsSellerDAO sellerDAO;
	
	@RequestMapping(method=RequestMethod.GET, value="/seller/changePassword")
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		System.out.println("SellerChangePasCtrl.changePassword()");
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		//String confirmPassword = request.getParameter("confirmPassword");
		
		PsSeller currentSeller = (PsSeller)request.getSession().getAttribute("currentSeller");
		
		PsSeller databaseSeller = sellerDAO.findByEmail(currentSeller.getEmail());
		
		PrintWriter out = response.getWriter();
		
		String msg = "";
		
		if(!oldPassword.equals(databaseSeller.getPassword())) {
			msg = "notequal";
		}
		else {
			databaseSeller.setPassword(newPassword);
			sellerDAO.update(databaseSeller);
			msg = "success";
		}
		
		out.write(msg);
		out.flush();
		out.close();
		
	}
}
