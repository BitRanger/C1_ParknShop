package com.bitranger.parknshop.common.controller;

public class Utility {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger("primary");
	
	public static String error(String message)
	{
		log.error(message);
		return "redirect:/";
	}
}
