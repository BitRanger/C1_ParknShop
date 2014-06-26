package com.bitranger.parknshop.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

/**
 * This class is a controller for confirming that the order has received
 * successfully.
 * 
 * @author Yu Bowen
 * @author Zhang Qinchuan
 */

@Controller
public class ConfirmReceived {
	@Autowired
	private PsOrderDAO psOrderDao;

	@Autowired
	private PsAdministratorDAO psAdministratorDao;

	@Autowired
	private PsSellerAccDAO psSellerAccDao;

	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MakeOrder.class.getName());

	/**
	 * @param req
	 * @param orderId
	 *            the id of the specified order
	 * @return
	 */
	@RequestMapping("/confirmOrderReceived")
	public String confirmReceived(HttpServletRequest req, Integer orderId) {
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
		if (psOrder.getStatus().equals(OrderStatus.DELIVERING)) {
			psOrder.setStatus(OrderStatus.FINISHED);
			psOrderDao.update(psOrder);
			@SuppressWarnings("unchecked")
			List<PsSellerAcc> psSellerAccs = psSellerAccDao.findByProperty(
					"id_seller", psOrder.getPsShop().getPsSeller().getId());
			PsSellerAcc account = psSellerAccs.get(0);
			double balance = account.getBalance();
			account.setBalance(balance + psOrder.getPriceTotal());
			psSellerAccDao.update(account);

			PsAdministrator psAdministrator = psAdministratorDao.findById(1);
			psAdministrator.setBalance(psAdministrator.getBalance()
					- psOrder.getPriceTotal());
			psAdministratorDao.update(psAdministrator);
			
		}
		return "redirect:/";
	}
}
