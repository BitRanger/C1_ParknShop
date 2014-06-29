package com.bitranger.parknshop.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 */
@Controller
public class ShowConfirmOrder {
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
	
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
	public String confirmOrder(HttpServletRequest req) {
		log.debug("Confirm Order.");
		
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		
		if (currentCustomer == null) {
			return Utility.error("User haven't logged in.");
		}
		List<PsRecipient> psRecipients = psRecipientDAO.findByCustomId(currentCustomer.getId());
		req.setAttribute("psRecipients", psRecipients);
		FetchOption fetchOption = new FetchOption();
		fetchOption.limit=100;
		fetchOption.offset=0;
		fetchOption.sortOption=SortOption.DESCENDING;
		List<CartCustomerItem> psCartItems = psCartCustomerItemDao.findByCustomerId(currentCustomer.getId(), fetchOption);
		req.setAttribute("psCartItems", psCartItems);
		return "confirmOrder";
	}
}
