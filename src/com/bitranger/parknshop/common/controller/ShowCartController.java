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
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 * Attributes in Request
 *	cartCustomerItems - List<CartCustomerItem>
 */
@Controller
public class ShowCartController {
	@Autowired
	CartCustomerItemDAO psCartCustomerItemDao;

	@Autowired
	PsItemDAO psItemDao;

	@RequestMapping(value = "/cart")
	public String showCart(HttpServletRequest req) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null)
			return Utility.error("Not Login");
		FetchOption option = new FetchOption();
		option.offset=0;
		option.limit=10000;
		option.sortOption=SortOption.DESCENDING;
		List<CartCustomerItem> cartCustomerItems = psCartCustomerItemDao.findByCustomerId(currentCustomer.getId(), option);
		req.setAttribute("cartCustomerItems", cartCustomerItems);
		return "cartView";
	}
}
