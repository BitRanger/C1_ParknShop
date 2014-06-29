package com.bitranger.parknshop.seller.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.ads.PsPromotItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.dao.PsNoticeSellerDAO;
import com.bitranger.parknshop.seller.dao.impl.PsShopDAO;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShop;

@Controller
public class SellerLogin {
	
	@Autowired
	private IPsSellerDAO psSellerDao;
	
	@Autowired
	@Qualifier(value="psShopDAO")
	private PsShopDAO psShopDAO;
	
	@Autowired
	@Qualifier(value="psPromotItemDAO")
	private PsPromotItemDAO psPromotItemDAO;
	
	@Autowired
	PsNoticeSellerDAO psNoticeSellerDAO;
	
	
	@RequestMapping(value = "/seller/sellerlogin", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView sellerLogin(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		PsSeller seller = psSellerDao.findByEmail(email);
		if (seller == null) {
System.out.println("SellerLogin.sellerLogin()");
System.out.println();
			return new ModelAndView("404");
		}
		//System.out.println(seller.getNickname());
		if (seller.getPassword().equals(password)){
			
			String b = "false";
			
			List<PsPromotItem> promotItems = new ArrayList<PsPromotItem>();
			List<PsShop> shops = psShopDAO.findBySellerId(seller.getId());
			if(shops == null || shops.size() == 0) {
				
			} 
			else {
				b = "true";
				promotItems = psPromotItemDAO.findBySeller(seller.getId());
			}
			
			request.setAttribute("ad_list", promotItems);
			session.setAttribute("currentSeller", seller);
			session.setAttribute("b", b);
			mav.setViewName("seller");
		}
		else {
			System.out.println("SellerLogin.sellerLogin()");
			System.out.println();
			mav.setViewName("404");
		}
		mav.addObject("notice_list", psNoticeSellerDAO.findByIsValid((short)1));
		return mav;
	}
}
