/*******************************************************************************
 * Copyright (c) 2014 BitRanger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     BitRanger - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.dao;


import com.bitranger.parknshop.dao.impl.SortOption;

/**
 * 
 * @author BowenCai
 *
 */
public class FetchOption {

	/**
	 * sort option can be ignored, by default it is descending
	 */
	SortOption sortOption = SortOption.DESCENDING;
	int offset = 0;
	int limit = Integer.MAX_VALUE;
	
	public static FetchOption newOption() {
		return new FetchOption();
	}
	
	public FetchOption limit(int l) {
		this.limit = l;
		return this;
	}
	public FetchOption offset(int o) {
		this.offset = o;
		return this;
	}
	public FetchOption sort(SortOption op) {
		this.sortOption = op;
		return this;
	}
}
