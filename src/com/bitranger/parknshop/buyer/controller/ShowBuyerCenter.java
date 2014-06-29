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
import com.bitranger.parknshop.seller.OrderState;
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
public class ShowBuyerCenter {
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
			.getLogger(ShowBuyerCenter.class.getName());

	@RequestMapping("/buyerCenter")
	public String showBuyerCenter(HttpServletRequest req) {
		log.debug("Enter Buyer Center");

		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");

		if (currentCustomer == null) {
			log.error("User haven't logged in but submitted an order.");
			return "redirect:/";
		}
		
		List<PsOrder> psOrders = psOrderDao.findByCustomerId(currentCustomer.getId());
		req.setAttribute("psOrders", psOrders);
		
		return "buyer";
	}
}
