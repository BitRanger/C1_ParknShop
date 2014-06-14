package com.bitranger.parknshop.common.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.CartCustomerItemId;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 */
@Controller
public class ModifyCartController {
	@Autowired
	CartCustomerItemDAO psCartCustomerItemDao;

	@Autowired
	PsItemDAO psItemDao;

	@RequestMapping(value = "/increaseCartItem")
	public String increaseCartItem(HttpServletRequest req, Integer itemId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		CartCustomerItem item = psCartCustomerItemDao
				.findById(new CartCustomerItemId(currentCustomer.getId(),
						itemId));
		if (item != null) {
			item.setQuantity(item.getQuantity() + 1);
			psCartCustomerItemDao.update(item);
			return "redirect:/cart";
		}
		return "redirect:/cart";
	}

	@RequestMapping(value = "/decreaseCartItem")
	public String decreaseCartItem(HttpServletRequest req, Integer itemId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		CartCustomerItem item = psCartCustomerItemDao
				.findById(new CartCustomerItemId(currentCustomer.getId(),
						itemId));
		if (item != null) {
			Integer quantity = item.getQuantity();
			if (quantity >= 2) {
				item.setQuantity(quantity-1);
				psCartCustomerItemDao.update(item);
			}
			return "redirect:/cart";
		}
		return "redirect:/cart";
	}
}
