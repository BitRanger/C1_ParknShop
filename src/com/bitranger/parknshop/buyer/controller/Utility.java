package com.bitranger.parknshop.buyer.controller;

import com.bitranger.parknshop.common.model.OrderStatus;

public class Utility {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger("primary");
	
	public static String error(String message)
	{
		log.error(message);
		return "redirect:/404.jsp?message=" + message;
	}
	
	public static String slice(String title, int len)
	{
		if(title.length() <= len)
			return title;
		return title.substring(0, len) + "...";
	}
	
	public static String printStatus(Short orderStatus)
	{
		if(orderStatus.equals(OrderStatus.FINISHED))
		{
			return "Finished";
		}else if(orderStatus.equals(OrderStatus.CANCELLED))
		{
			return "Cancelled";
		}else if(orderStatus.equals(OrderStatus.DELIVERING))
		{
			return "Delivering";
		}else if(orderStatus.equals(OrderStatus.EXCEPTION))
		{
			return "Exception";
		}else if(orderStatus.equals(OrderStatus.PAID))
		{
			return "Paid";
		}else if(orderStatus.equals(OrderStatus.UNPAID))
		{
			return "Unpaid";
		}
		return null;
	}
}
