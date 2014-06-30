/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShop;
import com.bitranger.parknshop.seller.model.PsShopApply;


/**
 *@author BowenCai
 *@since 9:22:46 PM
 */
@Controller
public class CtrlIndex extends PropHolder {

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView adminIndex(ModelAndView mv) {
		
		inject(mv);
		
		mv.setViewName("admin");
		
		List ls = psAdministratorDAO.findAll();
		if (ls != null && ls.size() > 0)
			mv.addObject("cur_admin", ls.get(0));
		else {
			System.out.println("CtrlIndex.adminIndex()");
			System.err.println("No admin");
		}
		
		mv.addObject("shopapply_list", psShopApplyDAO.findAll());
		mv.addObject("notice_list", psNoticeAdminDAO.findByIsValid(new Short((short)1)));
		mv.addObject("seller_list", psSellerDAO.findAll(new FetchOption().descending().limit(20)));
		mv.addObject("buyer_list", psCustomerDAO.findAll(new FetchOption().descending().limit(50)));
		mv.addObject("ad_list", psPromotItemDAO.findAllValid());
		
		mv.addObject("order_list", psOrderDAO.findAll(OrderStatus.FINISHED));
		mv.addObject("count_orders", psOrderDAO.findAll(OrderStatus.FINISHED).size());
		
		double tnxV = psOrderDAO.countTnxVolumn();
		mv.addObject("tnx_volumn", tnxV);
		double ro = tnxV * 0.01;
		double ra = psPromotItemDAO.calAdRevenue();
		double sum = ro + ra;
		mv.addObject("revenue_orders", ro);
		mv.addObject("revenue_ads", ra);
		mv.addObject("ratio_order", ro / sum);
		mv.addObject("ratio_ad", ra / sum);
		
		return mv;
	}
	
	@RequestMapping(value="/admin/delete/notice/id/{cur_id}", method=RequestMethod.GET)
	public String deleteNotice(@PathVariable("cur_id") Integer id) {
		
//		String id = request.getParameter("id");
//		Integer i =  Integer.parseInt(id);
		System.out.println("CtrlDelete.name()");
		System.out.println(id);
		
		psNoticeAdminDAO.delete(psNoticeAdminDAO.findById(id));
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/admin/approve/apply/id/{cur_id}", method=RequestMethod.GET)
	public String approveShopApply(@PathVariable("cur_id") Integer id) {
		PsShopApply sa = psShopApplyDAO.findById(id);
		psShopApplyDAO.delete(sa);
		PsSeller seller = psSellerDAO.findById(sa.getIdSeller());
		seller.getPsShops().add(new PsShop(seller, "My New Shop", (short)1));
		psSellerDAO.update(seller);
		return "redirect:/admin";
	}

	@RequestMapping(value="/redirect/ad/detail", method=RequestMethod.GET)
	public void redAd(HttpServletRequest request, HttpServletResponse resp) {
		
//		detail?id=????
		System.out.println("CtrlIndex.red()");
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		
	}
	
	
}
