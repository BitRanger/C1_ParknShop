package com.bitranger.parknshop.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitranger.parknshop.common.dao.impl.PsCategoryDAO;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.dao.impl.PsTagDAO;
import com.bitranger.parknshop.common.model.PsCategory;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;
import com.bitranger.parknshop.seller.dao.impl.PsShopDAO;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShop;
import com.sun.mail.handlers.image_gif;


@Controller
public class SellerPublishProductCtrl {

	@Autowired
	@Qualifier(value="psCategoryDao")
	private PsCategoryDAO categoryDAO;
	
	
	@Autowired
	@Qualifier(value="psTagDao")
	private PsTagDAO tagDAO;
	
	@Autowired
	@Qualifier(value="psShopDAO")
	private PsShopDAO psShopDAO;
	
	@Autowired
	@Qualifier(value="psItemDAO")
	private PsItemDAO psItemDAO;
	
	@RequestMapping(value="/seller/getcategory", method=RequestMethod.POST)
	public void getCategories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<PsCategory> categories = categoryDAO.findAll();
		
		PrintWriter out = response.getWriter();
		
		JsonConfig jsonConfig = new JsonConfig();
		
		jsonConfig.setIgnoreDefaultExcludes(false);
		
		jsonConfig.setExcludes(new String[]{"psItems"});
		
		JSONArray jsonArray = JSONArray.fromObject(categories, jsonConfig);
		
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		
	}
	
	@RequestMapping(value="/seller/getTag", method=RequestMethod.GET)
	public void getTags(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// get the categoryId
		String categoryId = request.getParameter("id");
		
		List<PsTag> tags = tagDAO.selectTopTags(Integer.parseInt(categoryId.trim()), 
				20);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[]{"psItems"});
		
		JSONArray jsonArray = JSONArray.fromObject(tags, jsonConfig);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		
	}
	
	@RequestMapping(value="/seller/publishPro", method=RequestMethod.POST)
	public void savePro(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		http://c1-parknshop.qiniudn.com/ceg_huafengv700_1.jpg
		String prefixUrlPic = "http://c1-parknshop.qiniudn.com/";
		
		PsSeller psSeller = (PsSeller)request.getSession().getAttribute("currentSeller");
		
		String name = request.getParameter("name");
		String categoryId = request.getParameter("categoryId");
		String[] tagsId = request.getParameterValues("tags[]");
		String[] urlPics = new String[5];
		String[] pics = request.getParameterValues("pics[]");
		String price = request.getParameter("price");

		String firstStr = "";
		// to generate the url pic
		for(int i = 0; i < pics.length; i++) {
			String str = pics[i];
			//String[] splitStr = str.split("\\\\");
			pics[i] = prefixUrlPic + str;
			
			if(i == 0) {
				firstStr = pics[i];
			}
		}
		
		for(int i = 0; i < pics.length; i++) {
			urlPics[i] = pics[i];
		}
		//String promotion = request.getParameter("promotion");
		String description = request.getParameter("description");
		String extra1 = request.getParameter("extra1");
		
		
		PsShop psShop = psShopDAO.findBySellerId(psSeller.getId()).get(0);
		
		PsItem psItem = new PsItem();
		psItem.setPsShop(psShop);
		
		PsCategory psCategory = categoryDAO.findById(Integer.parseInt(categoryId));
		psItem.setPsCategory(psCategory);
		
		psItem.setName(name);
		psItem.setIntroduction(description);
		psItem.setPrice(Double.parseDouble(price));
		psItem.setExtra1(extra1);
		
		Set<PsTag> tags = new HashSet<PsTag>();
		
		if(tagsId != null) {
			List<PsTag> tagsList = tagDAO.findTagByIds(tagsId);
			for(int i = 0; i < tagsList.size(); i++) {
				tags.add(tagsList.get(i));
			}
		}
		
		String urlPicrures = "";
		
		System.out.println("urlPics length : " + pics.length);
		
		if(urlPics != null) {
			
			if(pics.length < 5) {
				
				for(int j = pics.length; j < 5; j++) {
					urlPics[j] = firstStr;
				}
			}
			
			for(int i = 0; i < 5; i++) {
					
				urlPicrures += urlPics[i];
				if(i != urlPics.length - 1) {
					urlPicrures += ";";
				}
			}
			
		}
		
		
		psItem.setUrlPicture(urlPicrures);
		psItem.setPsTags(tags);
		psItem.setCountPurchase(0);
		psItem.setCountClick(0);
		psItem.setCountFavourite(0);
		psItem.setVote(new Double(0));
		psItem.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		psItemDAO.save(psItem);
		
		//System.out.println(name + "-" + categoryId);
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
		
	}
}
