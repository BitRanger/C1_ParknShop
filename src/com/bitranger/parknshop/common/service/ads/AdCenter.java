package com.bitranger.parknshop.common.service.ads;

import org.springframework.beans.factory.annotation.Autowired;




/**
 *@author BowenCai
 *@since 9:12:21 AM
 */
public class AdCenter {

	@Autowired
	public IItemAdService itemAdService;
	
	@Autowired
	public IShopAdService shopAdService;
	
	
	
	/**
	 * @return the itemAdService
	 */
	public IItemAdService getItemAdService() {
		return itemAdService;
	}

	/**
	 * @param itemAdService the itemAdService to set
	 */
	public void setItemAdService(IItemAdService itemAdService) {
		this.itemAdService = itemAdService;
	}

	/**
	 * @return the shopAdService
	 */
	public IShopAdService getShopAdService() {
		return shopAdService;
	}

	/**
	 * @param shopAdService the shopAdService to set
	 */
	public void setShopAdService(IShopAdService shopAdService) {
		this.shopAdService = shopAdService;
	}

	
}
