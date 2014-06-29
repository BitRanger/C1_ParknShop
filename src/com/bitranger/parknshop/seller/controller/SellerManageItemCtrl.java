package com.bitranger.parknshop.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsCategory;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;
import com.bitranger.parknshop.seller.controller.SellerOrderDisplay.ModifyCategoty;
import com.bitranger.parknshop.seller.controller.SellerOrderDisplay.ModifyItem;
import com.bitranger.parknshop.seller.controller.SellerOrderDisplay.ModifyTag;


/**
 * @author Administrator
 *
 */
@Controller
public class SellerManageItemCtrl {

	@Autowired
	@Qualifier(value="psItemDao")
	private PsItemDAO psItemDAO;
	
	@RequestMapping(value="/seller/modifyItem", method=RequestMethod.GET) 
	public void clickModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String itemId = request.getParameter("id");
		
		PsItem psItem = psItemDAO.findById(Integer.parseInt(itemId));
		
		Set<PsTag> tags = psItem.getPsTags();
		
		Set<ModifyTag> modiyTags = new HashSet<ModifyTag>();
		
		Iterator<PsTag> it = tags.iterator();
		
		while (it.hasNext()) {
			
			PsTag tag = it.next();
			
			ModifyTag modifyTag = new ModifyTag();
			modifyTag.setId(tag.getId());
			modifyTag.setName(tag.getName());
			modiyTags.add(modifyTag);
		}
		
		ModifyItem modifyItem = new ModifyItem();
		modifyItem.setTags(modiyTags);
		
		PsCategory psCategory = psItem.getPsCategory();
		ModifyCategoty modifyCategoty = new ModifyCategoty();
		modifyCategoty.setId(psCategory.getId());
		modifyCategoty.setDescription(psCategory.getName());
		modifyItem.setModifyCategory(modifyCategoty);

		modifyItem.setName(psItem.getName());
		modifyItem.setDescription(psItem.getIntroduction());
		modifyItem.setExtra1(psItem.getExtra1());
		modifyItem.setPrice(psItem.getPrice());
		modifyItem.setUrlPictuere(psItem.getUrlPicture());
		
		JSONArray jsonArray = JSONArray.fromObject(modifyItem);
		
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		
	}
	
	@RequestMapping(value="/seller/deleteItem", method=RequestMethod.GET)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String itemId = request.getParameter("id");
		
		psItemDAO.delete(psItemDAO.findById(Integer.parseInt(itemId)));
		
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
		
	}

}
