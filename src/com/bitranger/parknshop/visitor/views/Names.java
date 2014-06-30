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
package com.bitranger.parknshop.visitor.views;




public class Names {

	public static class URLs {
		public static final String item_list = "item-list";

		public static final String item_detail = "item-detail";
	}
	//			/item?tag=a&b&c&category_id=3
	
	// form <input name="category_id">
	
	public static class params {
		
		public static final String categoryId = "category_id";
		public static final String tag = "tag";
		public static final String maxPrice = "max_price";
		public static final String minPrice = "min_price";
		public static final String pageNumber = "page_number";
		public static final String orderBy = "order_by";
		public static final String asd = "asd";
		
		public static final String itemId = "item-id";
		
	}
	
	public static class model {
		
		public static final String itemList = "item-list";
		public static final String item = "item";
	}
	
}
