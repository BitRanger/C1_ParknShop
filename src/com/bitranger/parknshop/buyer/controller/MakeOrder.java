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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.common.model.ROrderItem;
import com.bitranger.parknshop.common.model.ROrderItemId;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsRecipient;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * @author Yu Bowen
 * @author Zhang Qinchuan
 * 
 *         Prerequisite: User should be login
 * 
 * 
 */
@Controller
public class MakeOrder {
	@Autowired
	private IPsCategoryDAO psCategoryDao;

	@Autowired
	private IPsItemDAO psItemDao;

	@Autowired
	private IPsOrderDAO psOrderDao;

	@Autowired
	private ICartCustomerItemDAO psCartCustomerItemDao;

	@Autowired
	private IPsRecipientDAO psRecipientDAO;

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MakeOrder.class.getName());

	@RequestMapping("/submitOrder")
	public String submitOrder(HttpServletRequest req, Integer psRecipientId) {
		if (psRecipientId == null)
			return "redirect:/";
		log.debug("Order submitted.");

		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");

		if (currentCustomer == null) {
			log.error("User haven't logged in but submitted an order.");
			return "redirect:/";
		}

		PsRecipient psRecipient = psRecipientDAO.findById(psRecipientId);
		if (psRecipient == null
				|| (!psRecipient.getPsCustomer().getId()
						.equals(currentCustomer.getId())))
			return Utility.error("Recipient ID is invalid.");

//		FetchOption option = new FetchOption();
//		option.ascending();
//		option.offset = 0;
//		option.limit = 100;
		List<CartCustomerItem> cartItems = psCartCustomerItemDao
				.findByCustomerId(currentCustomer.getId(), new FetchOption().limit(100).ascending());
		
		Map<PsShop, Set<CartCustomerItem>> shopToPsOrder = new HashMap<PsShop, Set<CartCustomerItem>>();
		for (CartCustomerItem item : cartItems) {
			PsShop currentShop = item.getPsItem().getPsShop();
			Set<CartCustomerItem> currentSet = shopToPsOrder.get(currentShop);
			if (currentSet == null) {
				currentSet = new HashSet<CartCustomerItem>();
			}
			currentSet.add(item);
			shopToPsOrder.put(currentShop, currentSet);
		}

		for (PsShop psShop : shopToPsOrder.keySet()) {
			Set<CartCustomerItem> currentShopSet = shopToPsOrder.get(psShop);
			PsOrder transientOrder = new PsOrder();
			transientOrder.setStatus(OrderStatus.UNPAID);
			transientOrder.setTimeCreated(new Timestamp(System
					.currentTimeMillis()));
			transientOrder.setPsCustomer(currentCustomer);
			transientOrder.setPriceTotal(0.0);
			transientOrder.setPsRecipient(psRecipient);
			transientOrder.setPsShop(psShop);
			log.debug("Ready to save the transient order to the DB");
			psOrderDao.save(transientOrder);
			Set<ROrderItem> orderItems = new HashSet<>();
			double priceTotal = 0.0;
			for (CartCustomerItem item : currentShopSet) {
				ROrderItem order_item = new ROrderItem(new ROrderItemId(item
						.getId().getIdItem(), transientOrder.getId()),
						item.getPsItem(), transientOrder, item.getQuantity(),
						item.getExtra1(), item.getExtra2());
				orderItems.add(order_item);
				priceTotal += item.getPsItem().getPrice() * item.getQuantity();
			}
			transientOrder.setPriceTotal(priceTotal);
			transientOrder.setROrderItems(orderItems);
			psOrderDao.update(transientOrder);
			log.debug("Save successfully");
		}
		
		psCartCustomerItemDao.deleteAll(cartItems);

		return "thankyou";
	}
}
