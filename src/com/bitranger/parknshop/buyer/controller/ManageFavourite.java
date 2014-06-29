package com.bitranger.parknshop.buyer.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.buyer.dao.CustomerFavouriteItemDAO;
import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteItem;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteItemId;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.ads.AdCenter;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsRecipient;
import com.bitranger.parknshop.visitor.view.VisitorParams;
import com.bitranger.parknshop.visitor.view.VisitorView;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 */
@Controller
public class ManageFavourite {
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
	private CustomerFavouriteItemDAO psCustomerFavouriteItemDao;

	@Autowired
	AdCenter adCenter;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MakeOrder.class.getName());

	@RequestMapping("/addFavourite")
	public String addFavourite(HttpServletRequest req, Integer psItemId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");

		if (currentCustomer == null) {
			return Utility.error("User haven't logged in.");
		}

		PsItem psItem = psItemDao.findById(psItemId);
		if (psItem == null)
			return Utility.error("Wrong ItemId");
		CustomerFavouriteItem customerFavouriteItem = psCustomerFavouriteItemDao
				.findById(new CustomerFavouriteItemId(currentCustomer.getId(),
						psItemId));
		if(customerFavouriteItem == null)
		{
			customerFavouriteItem = new CustomerFavouriteItem();
			customerFavouriteItem.setPsCustomer(currentCustomer);
			customerFavouriteItem.setPsItem(psItem);
			customerFavouriteItem.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			customerFavouriteItem.setId(new CustomerFavouriteItemId(currentCustomer.getId(),
					psItemId));
			psCustomerFavouriteItemDao.save(customerFavouriteItem);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/removeFavourite")
	public String removeFavourite(HttpServletRequest req, Integer psItemId) {
		PsCustomer currentCustomer = (PsCustomer) req.getSession()
				.getAttribute("currentCustomer");

		if (currentCustomer == null) {
			return Utility.error("User haven't logged in.");
		}

		PsItem psItem = psItemDao.findById(psItemId);
		if (psItem == null)
			return Utility.error("Wrong ItemId");
		CustomerFavouriteItem customerFavouriteItem = psCustomerFavouriteItemDao
				.findById(new CustomerFavouriteItemId(currentCustomer.getId(),
						psItemId));
		if(customerFavouriteItem != null)
		{
			psCustomerFavouriteItemDao.delete(customerFavouriteItem);
		}
		return "redirect:/";
	}
	
//	show_shop

	@RequestMapping("/show_shop")
	public ModelAndView showShop(HttpServletRequest req, Integer psItemId) {
		PsItem item = psItemDao.findById(psItemId);
		List<PsItem> itemList = psItemDao.findByShop(item.getPsShop().getId(), new FetchOption().descending().limit(100));
		
		for(PsItem psItem : itemList)
		{
			psItem.setIntroduction(Utility.slice(psItem.getIntroduction(), 40));
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject(VisitorParams.productItemList, itemList);
		mv.addObject(VisitorParams.itemCount, itemList.size());
		mv.setViewName(VisitorView.product);
		
		
		List<PsPromotItem> ads = adCenter.itemAdService.forItemList(itemList, 60, null);
		mv.addObject("ad_list", ads);
		
		return mv;
		
	}
}
