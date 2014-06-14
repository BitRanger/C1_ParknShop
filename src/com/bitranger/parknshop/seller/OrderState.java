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
package com.bitranger.parknshop.seller;

public class OrderState {
	
	public static final Short UnPaid = 1;
	public static final Short UnDeliver = 2; 
	public static final Short Delivering = 3; 
	public static final Short Accepted = 4;
	
	/**
	 * 投诉了，在审核
	 */
	public static final Short Blocked = 5;
	public static final Short Canceled = 6;

	public static final Short OK = 7;
}
