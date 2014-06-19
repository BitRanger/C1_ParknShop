package com.bitranger.parknshop.buyer.controller;

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
public class AddCartController {
	@Autowired
	CartCustomerItemDAO psCartCustomerItemDao;

	@Autowired
	PsItemDAO psItemDao;

	@RequestMapping(value = "/addcart")
	public String addCart(HttpServletRequest req, Integer itemId) {
		PsItem psItem = psItemDao.findById(itemId);
		if(psItem == null)
			return Utility.error("Unexisted item");
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		CartCustomerItem item = psCartCustomerItemDao.findById(new CartCustomerItemId(currentCustomer.getId(), itemId));
		if(item != null)
		{
				item.setQuantity(item.getQuantity()+1);
				psCartCustomerItemDao.update(item);
				return "redirect:/";
		}
		CartCustomerItem transientItem = new CartCustomerItem();
		transientItem.setId(new CartCustomerItemId(currentCustomer.getId(), itemId));
		transientItem.setPsCustomer(currentCustomer);
		transientItem.setPsItem(psItem);
		transientItem.setQuantity(1);
		transientItem.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		psCartCustomerItemDao.save(transientItem);
		return "redirect:/";
	}
}
