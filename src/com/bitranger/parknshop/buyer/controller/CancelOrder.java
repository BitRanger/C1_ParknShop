package com.bitranger.parknshop.buyer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.admin.data.PsAdministrator;
import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.impl.PsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * This class is a controller for canceling an order.
 * 
 * 
 * @author Yu Bowen
 * @author Zhang Qinchuan
 */

@Controller
public class CancelOrder {
	@Autowired
	private PsOrderDAO psOrderDao;

	@Autowired
	private PsAdministratorDAO psAdministratorDao;

//	@Autowired
//	private PsSellerAccDAO psSellerAccDao;

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MakeOrder.class.getName());

	/**
	 * @param req
	 * @param orderId
	 *            the id of the specified order
	 * @return
	 */
	@RequestMapping("/cancelOrder")
	public String cancelOrder(HttpServletRequest req, Integer orderId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		log.info("try to confirm received the order.");
		if (orderId == null)
			return Utility.error("Param insufficient.");
		PsOrder psOrder = psOrderDao.findByOrderId(orderId);
		if (psOrder == null) {
			return Utility.error("No such order.");
		}
		if (psOrder.getStatus().equals(OrderStatus.UNPAID)) {
			log.info("From unpaid order.");
			psOrder.setStatus(OrderStatus.CANCELLED);
			psOrderDao.update(psOrder);
		} else if (psOrder.getStatus().equals(OrderStatus.PAID)) {
			log.info("From paid order.");
			psOrder.setStatus(OrderStatus.CANCELLED);
			psOrderDao.update(psOrder);
			PsAdministrator psAdministrator = psAdministratorDao.findById(1);
			psAdministrator.setBalance(psAdministrator.getBalance()
					- psOrder.getPriceTotal());
			// TODO: Refund to the customer here.
			psAdministratorDao.update(psAdministrator);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/confirmReceived")
	public String confirmedReceived(HttpServletRequest req, Integer orderId)
	{
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		log.info("try to confirm received the order.");
		if (orderId == null)
			return Utility.error("Param insufficient.");
		PsOrder psOrder = psOrderDao.findByOrderId(orderId);
		if (psOrder == null) {
			return Utility.error("No such order.");
		}
		if(psOrder.getStatus().equals(OrderStatus.DELIVERING))
		{
			psOrder.setStatus(OrderStatus.FINISHED);
			psOrderDao.update(psOrder);
		}
		return "redirect:/buyerCenter";
	}
}
