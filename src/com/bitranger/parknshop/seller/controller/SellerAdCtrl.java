package com.bitranger.parknshop.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitranger.parknshop.common.ads.PsAdItem;
import com.bitranger.parknshop.common.ads.PsAdItemDAO;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.ads.PsPromotItemDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.IROrderItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;


@Controller
public class SellerAdCtrl {

	@Autowired
	@Qualifier(value="psOrderDao")
	IPsOrderDAO psOrderDao;
	
	@Autowired
	@Qualifier(value="psItemDao")
	IPsItemDAO psItemDao;
	
	@Autowired
	IROrderItemDAO rOrderItemDAO;
	
	@Autowired
	PsPromotItemDAO psPromotItemDAO;
	
	@Autowired
	PsAdItemDAO psAdItemDAO;
	
	
	@RequestMapping(value="/seller/addAd", method=RequestMethod.POST)
	public void getItems(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		
		String name = request.getParameter("adName");
		String itemId = request.getParameter("itemId");
		String startDate = request.getParameter("start");
		String endDate = request.getParameter("end");
		String weight = request.getParameter("weight");
		String description = request.getParameter("description");
		String picUrl = request.getParameter("pic-url");
		
		System.out.println(name + ": " + itemId + ";" + startDate + ";" + 
				endDate + "; " + weight + ";" + description);
		
		PsItem $ = psItemDao.findById(Integer.parseInt(itemId));
		SimpleDateFormat FMT = new SimpleDateFormat("yyyy-MM-dd");
		
		PsPromotItem pi = new PsPromotItem();
		pi.setPsItem($);
		pi.setDescription(description);
		pi.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		pi.setPicUrl(picUrl);
		psPromotItemDAO.save(pi);
		
		PsAdItem ad = new PsAdItem();
		ad.setIdPromot(pi.getId());
		ad.setTimeStart(new Timestamp(FMT.parse(startDate).getTime()));
		ad.setTimeEnd(new Timestamp(FMT.parse(endDate).getTime()));
		ad.setWeight(Double.parseDouble(weight));
		
		psAdItemDAO.save(ad);
		
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
}
