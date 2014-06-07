package com.bitranger.parknshop.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * @author Yu Bowen
 * The responsibility of this controller is about payment.
 * For now, the mock 'payment' always succeed without actual
 * payment.
 */
@Controller
@RequestMapping("/payment")
public class Payment {
	@Autowired
	private IPsCategoryDAO psCategoryDao;

	@Autowired
	private IPsItemDAO psItemDao;

	@Autowired
	private IPsOrderDAO psOrderDao;

	@Autowired
	private ICartCustomerItemDAO psCartCustomerItemDao;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Payment.class.getName());
	
	@RequestMapping(value="/begin")
	public String beginPayment(HttpServletRequest req, Integer psOrderId)
	{
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null) {
			return Utility.error("User haven't logged in but submitted an order.");
		}
		if (psOrderId == null)
		{
			return Utility.error("Order Id unspecified. ");
		}
		PsOrder psOrder = psOrderDao.findByOrderId(psOrderId);
		if(psOrder == null)
		{
			return Utility.error("Order doesn't exist. ");
		}
		if(psOrder.getPsCustomer().getId() != currentCustomer.getId()) {
			return Utility.error("The user attempted to pay an order which does not belong to him");
		}
		psOrder.setStatus(OrderStatus.PAID);
		psOrderDao.update(psOrder);
		return "success_payment";
	}
}
