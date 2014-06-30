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
package com.bitranger.parknshop.seller;

public class OrderState {
	public static final Short UnPaid = 0;
	public static final Short UnDeliver = 1; 
	public static final Short Delivering = 2; 
	public static final Short Accepted = 3;
	public static final Short Blocked = 6;
	public static final Short Canceled = 5;
}
