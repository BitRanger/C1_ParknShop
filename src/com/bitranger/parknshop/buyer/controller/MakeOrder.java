package com.bitranger.parknshop.buyer.controller;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
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
		if(psRecipient == null || psRecipient.getPsCustomer().getId()!=currentCustomer.getId())
			return Utility.error("Recipient ID is invalid.");
		
		FetchOption option = new FetchOption();
		option.ascending();
		option.offset = 0;
		option.limit = 100;
		List<CartCustomerItem> cartItems = psCartCustomerItemDao
				.findByCustomerId(currentCustomer.getId(), option);
		PsOrder transientOrder = new PsOrder();
		Set<ROrderItem> orderItems = new HashSet<>();
		double priceTotal = 0.0;
		for (CartCustomerItem item : cartItems) {
			ROrderItem order_item = new ROrderItem(new ROrderItemId(item
					.getId().getIdItem(), transientOrder.getId()),
					item.getPsItem(), transientOrder, item.getQuantity(),
					item.getExtra1(), item.getExtra2());
			orderItems.add(order_item);
			priceTotal += item.getPsItem().getPrice() * item.getQuantity();
		}
		transientOrder.setROrderItems(orderItems);
		transientOrder.setStatus(OrderStatus.UNPAID);
		transientOrder
				.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		transientOrder.setPsCustomer(currentCustomer);
		transientOrder.setPriceTotal(priceTotal);
		transientOrder.setPsRecipient(psRecipient);
		log.debug("Ready to save the transient order to the DB");
		psOrderDao.save(transientOrder);
		log.debug("Save successfully");

		return "redirect:/thankyou";
	}
}
