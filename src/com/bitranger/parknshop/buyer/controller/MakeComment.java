package com.bitranger.parknshop.buyer.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.dao.impl.CartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsCommentDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.common.model.PsComment;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.ROrderItem;
import com.bitranger.parknshop.common.model.ROrderItemId;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsRecipient;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * @author Yu Bowen
 * @author Zhang Qinchuan
 * 
 *         Prerequisite: User should be login
 * 
 * 
 */
@Controller
public class MakeComment {
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
			.getLogger(MakeComment.class.getName());

	@RequestMapping("/makeComment")
	public @ResponseBody String makeComment(HttpServletRequest req, Integer psItemId, Integer scoreItem, Integer scoreShop, String content) {
		if (psItemId == null || scoreItem==null || scoreShop==null  || content==null)
			return "fail1";
		if(scoreItem.compareTo(0)<0 || scoreItem.compareTo(5)>0 || scoreShop.compareTo(0)<0 || scoreShop.compareTo(5)>0)
			return "fail2";
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");
		if (currentCustomer == null) {
			return "fail3";
		}
		PsItem psItem = psItemDao.findById(psItemId);
		if(psItem == null)
			return "fail4";
		PsComment psComment = new PsComment();
		psComment.setContent(content);
		psComment.setScore(scoreItem.shortValue());
//		psComment.set(scoreShop);
		psComment.setPsItem(psItem);
		psComment.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		psComment.setPsCustomer(currentCustomer);
		psCommentDao.save(psComment);
		return "success";
	}
}
