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

import com.bitranger.parknshop.buyer.dao.CustomerFavouriteItemDAO;
import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.dao.PsNoticeCustomerDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.SortOption;
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
	
	@Autowired
	private CustomerFavouriteItemDAO psCustomerFavouriteItemDao;

	@Autowired
	PsNoticeCustomerDAO psNoticeCustomerDAO;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ShowBuyerCenter.class.getName());

	@RequestMapping("/buyerCenter")
	public String showBuyerCenter(HttpServletRequest req) {
		log.debug("Enter Buyer Center");

		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");

		if (currentCustomer == null) {
			return Utility.error("User hasn't logged in.");
		}
		
		List<PsOrder> psOrders = psOrderDao.findByCustomerId(currentCustomer.getId());
		List<PsRecipient> psRecipients = psRecipientDAO.findByCustomId(currentCustomer.getId());
		FetchOption op = new FetchOption();
		op.limit=100;
		op.offset=0;
		op.sortOption=SortOption.DESCENDING;
		List<CustomerFavouriteItem> psFavourites = psCustomerFavouriteItemDao.findByCustomerId(currentCustomer.getId(), op );
		req.setAttribute("psOrders", psOrders);
		req.setAttribute("psRecipients", psRecipients);
		req.setAttribute("psFavourites", psFavourites);
		req.setAttribute("notice_list", psNoticeCustomerDAO.findByIsValid((short)1));
		return "buyer";
	}
}
