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
	public static final Short UnPaid = 0;
	public static final Short UnDeliver = 1; 
	public static final Short Delivering = 2; 
	public static final Short Accepted = 3;
	public static final Short Blocked = 6;
	public static final Short Canceled = 5;
}
