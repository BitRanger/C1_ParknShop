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

public enum OrderState {
	UnPaid, 
	UnDeliver, 
	Delivering, 
	Accepted, 
	/**
	 * 投诉了，在审核
	 */
	Blocked, 
	Canceled
}