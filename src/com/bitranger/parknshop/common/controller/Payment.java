package com.bitranger.parknshop.common.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.admin.data.PsAdminAcc;
import com.bitranger.parknshop.admin.data.PsAdminAccDAO;
import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * @author Yu Bowen
 * @author Zhang Qinchuan The responsibility of this controller is about
 *         payment. For now, the mock 'payment' always succeed without actual
 *         payment.
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
	
	@Autowired
	private PsAdminAccDAO psAdminAccDao;

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Payment.class.getName());

	@RequestMapping(value = "/begin")
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
		if (psOrder.getPsCustomer().getId() != currentCustomer.getId()) {
			return Utility
					.error("The user attempted to pay an order which does not belong to him");
		}
		PsAdminAcc psAdminAcc = psAdminAccDao.findById(1);
		Double balance = psAdminAcc.getBalance();
		psAdminAcc.setBalance(balance + psOrder.getPriceTotal());
		psAdminAccDao.update(psAdminAcc);
		psOrder.setStatus(OrderStatus.PAID);
		psOrder.setTimePaid(new Timestamp(System.currentTimeMillis()));
		log.info("Current balance " + balance.toString());
		psOrderDao.update(psOrder);
		return "success_payment";
	}
}
