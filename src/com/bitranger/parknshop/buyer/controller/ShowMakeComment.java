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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;

@Controller
public class ShowMakeComment {
	
	@Autowired
	PsItemDAO psItemDao;
	
	@RequestMapping("/comment")
	public String showMakeComment(HttpServletRequest req, Integer psItemId)
	{
		PsItem psItem = psItemDao.findById(psItemId);
		req.setAttribute("psItem", psItem);
		return "buyer/buyer_comment";
	}
}
