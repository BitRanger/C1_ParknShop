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
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitranger.parknshop.seller.dao.PsShopApplyDAO;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShopApply;


@Controller
public class SellerApplyShopCtrl {

	@Autowired
	@Qualifier(value="psShopApplyDAO")
	private PsShopApplyDAO psShopApplyDAO;
	
	@RequestMapping(value="/seller/applyShop", method=RequestMethod.GET)
	public void applyShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PsSeller psSeller = (PsSeller)request.getSession().getAttribute("currentSeller");
		
		String message = request.getParameter("msg");
		
		PsShopApply psShopApply = new PsShopApply();
		psShopApply.setIdSeller(psSeller.getId());
		psShopApply.setMessage(message);
		psShopApply.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		psShopApplyDAO.save(psShopApply);
		
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
}
