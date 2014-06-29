package com.bitranger.parknshop.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsCommentDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsComment;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 */
@Controller
public class ShowItemDetail {
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
	
	@Autowired
	private IPsCommentDAO psCommentDao;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MakeOrder.class.getName());
	
	@RequestMapping(value = "/item/{psItemId}", method = RequestMethod.GET)
	public String showItmeDetail(@PathVariable Integer psItemId, HttpServletRequest req) {
		PsItem psItem = psItemDao.findById(psItemId);
		if(psItem == null)
			Utility.error("No such item");
		req.setAttribute("psItem", psItem);
		FetchOption option = new FetchOption();
		option.limit=500;
		option.offset=0;
		option.sortOption = SortOption.DESCENDING;
		List<PsComment> psComments = psCommentDao.findByItemId(psItemId, option);
		req.setAttribute("psComments", psComments);
		return "detail";
	}
}