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
package com.bitranger.parknshop.common.model;

public class OrderStatus {
	public final static Short UNPAID = 0;
	public final static Short PAID = 1;
	public final static Short DELIVERING = 2;
	public final static Short FINISHED = 3;
	public final static Short EXCEPTION = 4;
	public final static Short CANCELLED = 5;
}
