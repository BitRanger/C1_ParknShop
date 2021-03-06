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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitranger.parknshop.admin.data.PsAdminAcc;
import com.bitranger.parknshop.admin.data.PsAdminAccDAO;
import com.bitranger.parknshop.admin.data.PsAdministrator;
import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.PsNoticeSellerDAO;
import com.bitranger.parknshop.seller.model.PsNoticeSeller;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * @author Yu Bowen
 * @author Zhang Qinchuan The responsibility of this controller is about
 *         payment. For now, the mock 'payment' always succeed without actual
 *         payment.
 */
@Controller
public class Payment {
	@Autowired
	private IPsCategoryDAO psCategoryDao;

	@Autowired
	private IPsItemDAO psItemDao;

	@Autowired
	private IPsOrderDAO psOrderDao;

	@Autowired
	private ICartCustomerItemDAO psCartCustomerItemDao;
	
	@Autowired
	private PsAdministratorDAO psAdministratorDao;
	
	@Autowired
	PsNoticeSellerDAO psNoticeSellerDAO;

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Payment.class.getName());

	@RequestMapping(value = "/submitPayment", method=RequestMethod.POST)
	public String beginPayment(HttpServletRequest req, Integer psOrderId,
			String bankCardId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null) {
			return Utility.error("User haven't logged in but tried to pay.");
		}
		if (psOrderId == null) {
			return Utility.error("Payment: Order Id unspecified. ");
		}
		PsOrder psOrder = psOrderDao.findByOrderId(psOrderId);
		if (psOrder == null) {
			return Utility.error("Payment: Order doesn't exist. ");
		}
		if (! psOrder.getPsCustomer().getId().equals(currentCustomer.getId())) {
			return Utility
					.error("The user attempted to pay an order which does not belong to him");
		}
		PsAdministrator psAdministrator = psAdministratorDao.findById(1);
		psAdministrator.setBalance(psAdministrator.getBalance()
				+ psOrder.getPriceTotal());
		psAdministratorDao.update(psAdministrator);
		
		psOrder.setStatus(OrderStatus.PAID);
		psOrder.setTimePaid(new Timestamp(System.currentTimeMillis()));
		log.info("Current balance " + psAdministrator.getBalance().toString());
		psOrderDao.update(psOrder);
		
		PsNoticeSeller n = new PsNoticeSeller(psOrder.getPsShop().getPsSeller(),
				new Timestamp(System.currentTimeMillis()), (short)1);
		n.setSource(((PsCustomer)req.getSession().getAttribute("currentCustomer")).getName());
		n.setSource("order paied");
		psNoticeSellerDAO.save(n);
		
		return "success_payment";
	}
}

