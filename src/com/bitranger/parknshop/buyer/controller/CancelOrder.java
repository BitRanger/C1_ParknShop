package com.bitranger.parknshop.buyer.controller;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.bitranger.parknshop.admin.data.PsAdministrator;
import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.impl.PsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
=======
import com.bitranger.parknshop.admin.data.PsAdminAcc;
import com.bitranger.parknshop.admin.data.PsAdminAccDAO;
import com.bitranger.parknshop.admin.data.PsAdministrator;
import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.CartCustomerItemId;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.OrderState;
import com.bitranger.parknshop.seller.dao.PsSellerAccDAO;
import com.bitranger.parknshop.seller.dao.impl.PsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsSellerAcc;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79

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

<<<<<<< HEAD
//	@Autowired
//	private PsSellerAccDAO psSellerAccDao;
=======
	@Autowired
	private PsSellerAccDAO psSellerAccDao;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79

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
<<<<<<< HEAD
	
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
=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
}
