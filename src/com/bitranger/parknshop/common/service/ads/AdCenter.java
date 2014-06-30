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
package com.bitranger.parknshop.common.service.ads;

import org.springframework.beans.factory.annotation.Autowired;




/**
 *@author BowenCai
 *@since 9:12:21 AM
 */
public class AdCenter {

	public IItemAdService itemAdService;
	
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
