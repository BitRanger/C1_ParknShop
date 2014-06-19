package com.bitranger.parknshop.buyer.controller;

public class Utility {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger("primary");
	
	public static String error(String message)
	{
		log.error(message);
		return "redirect:/";
	}
	
	public static String slice(String title, int len)
	{
		if(title.length() <= len)
			return title;
		return title.substring(0, len) + "...";
	}
}
