package com.bitranger.parknshop.buyer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 */
@Controller
public class ManageRecipient {
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

	@RequestMapping("/addRecipient")
	public String addRecipient(HttpServletRequest req, String province,
			String city, String town, String zipcode, String street,
			String receiver, String phonenum) {
		log.debug("Order submitted.");
		
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		
		if (currentCustomer == null) {
			return Utility.error("User haven't logged in.");
		}
		PsRecipient psRecipient = new PsRecipient();
		psRecipient.setCountry("China");
		psRecipient.setProvince(province);
		psRecipient.setCity(city);
		psRecipient.setPostalCode(zipcode);
		psRecipient.setAddresss(town);
		psRecipient.setDetailedAddr(street);
		psRecipient.setNameRecipient(receiver);
		psRecipient.setPhoneNumber(phonenum);
		psRecipient.setPsCustomer(currentCustomer);
		psRecipientDAO.save(psRecipient);
		return "redirect:/confirmOrder";
	}
}
