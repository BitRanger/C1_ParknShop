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
package com.bitranger.parknshop.common.dao;



/**
 * 
 * @author BowenCai
 *
 */
public class FetchOption {

	/**
	 * sort option can be ignored, by default it is descending
	 */
	public SortOption sortOption = SortOption.DESCENDING;
	public int offset = 0;
	public int limit = Integer.MAX_VALUE;
	
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
	public FetchOption ascending() {
		this.sortOption = SortOption.ASCENDING;
		return this;
	}
	public FetchOption descending() {
		this.sortOption = SortOption.DESCENDING;
		return this;
	}
}
