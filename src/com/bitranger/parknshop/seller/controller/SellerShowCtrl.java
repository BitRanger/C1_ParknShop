package com.bitranger.parknshop.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.bitranger.parknshop.buyer.dao.PsNoticeCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.IROrderItemDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.ROrderItem;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShop;

@Controller
public class SellerShowCtrl {
	@Autowired
	@Qualifier(value="psOrderDao")
	IPsOrderDAO psOrderDao;
	
	@Autowired
	@Qualifier(value="psItemDao")
	IPsItemDAO psItemDao;
	
	@Autowired
	IROrderItemDAO rOrderItemDAO;
	
	@Autowired
	PsNoticeCustomerDAO psNoticeCustomerDAO;
	
	
	@RequestMapping(value="/seller/record",method=RequestMethod.GET)
	public void showOrders(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		PsSeller seller = (PsSeller) request.getSession().getAttribute("currentSeller");
		if (seller == null) {
//			http://bowen_ultimate:8080/C1_ParknShop/seller/sellerlogin
			response.sendRedirect("/C1_ParknShop/sellerLogin.jsp");
			return;
		}
		
		Set<PsShop> shops =  seller.getPsShops();
		Iterator<PsShop> it = shops.iterator();
		List<PsOrder> orders = new ArrayList<PsOrder>();
		List<SellerOrderDisplay> orderDisplays = new ArrayList<SellerOrderDisplay>();
		
		//List<ROrderItem> orderItems = new ArrayList<ROrderItem>();
		
		while (it.hasNext()){
			PsShop shop = it.next();
			orders.addAll(psOrderDao.findByShopId(shop.getId()));
		}
		
		for(PsOrder order : orders) {
			
			Iterator<ROrderItem> iterator = order.getROrderItems().iterator();
			while(iterator.hasNext()) {
				
				ROrderItem orderItem = iterator.next();
				
				SellerOrderDisplay sellerOrderDisplay = new SellerOrderDisplay();
				sellerOrderDisplay.setId(order.getId());
				sellerOrderDisplay.setItemPic(orderItem.getPsItem().getUrlPicture());
				sellerOrderDisplay.setItemName(orderItem.getPsItem().getName());
				sellerOrderDisplay.setSoldTime(order.getTimeCreated());
				sellerOrderDisplay.setPrice(orderItem.getPsItem().getPrice());
				sellerOrderDisplay.setQuantity(orderItem.getQuantitiy());
				sellerOrderDisplay.setBuyerName(order.getPsCustomer().getName());
				sellerOrderDisplay.setState(order.getStatus());
				sellerOrderDisplay.setAddress(order.getPsRecipient().getAddresss());
				sellerOrderDisplay.setPhone(order.getPsRecipient().getPhoneNumber());
				
				orderDisplays.add(sellerOrderDisplay);
			}
			//orderItems.addAll(iROrderItemDAO.findByOrderId(order.getId()));
		}
		
		System.out.println(orderDisplays.size());
		
		/*JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[]{"psShop"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);*/
	    
		/*jsonConfig.registerJsonValueProcessor(ROrderItem.class,
				new ObjectJsonValueProcessor(new String[]{"quantity"}, ROrderItem.class));*/
		
		JSONArray jsonArray = JSONArray.fromObject(orderDisplays);
		
		System.out.println(jsonArray.toString());
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		
	}
	
	@RequestMapping(value="/seller/productList",method=RequestMethod.GET)
	public void showProductList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//ModelAndView mav = new ModelAndView();
		
		PsSeller seller = (PsSeller) request.getSession().getAttribute("currentSeller");
		
		List<PsItem> items =  psItemDao.findBySeller(seller.getId(), new FetchOption());
		
		//JSONObject jsonObject = JSONObject.fromObject(items);
		
		for(PsItem psItem : items) {
			System.out.println(psItem.getName());
			psItem.setUrlPicture(psItem.getUrlPicture().split(";")[0]);
		}
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[]{"customerFavouriteItems", "psPromotItems", "psComments", 
				"psTags", "cartCustomerItems", "ROrderItems", "psShop", "psCategory"});
		
		JSONArray jsonArray = JSONArray.fromObject(items, jsonConfig);
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		//mav.setViewName("seller_list");
		//mav.addObject("productlist", items);
		//return mav;
		
	}

	
	@RequestMapping(value="/seller/delivering", method=RequestMethod.GET)
	public void delivering(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String recordId = request.getParameter("id");
		
		PsOrder psOrder = psOrderDao.findByOrderId(Integer.parseInt(recordId));
		
		psOrder.setStatus(OrderStatus.DELIVERING);
		
		psOrderDao.update(psOrder);
		
		PsNoticeCustomer n = new PsNoticeCustomer(psOrder.getPsCustomer(),
				new Timestamp(System.currentTimeMillis()), psOrder.getPsShop().getName(),
				"Order[" + psOrder.getId() + "] delivered", (short)1);
		psNoticeCustomerDAO.save(n);
		
		try {
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} 
}
