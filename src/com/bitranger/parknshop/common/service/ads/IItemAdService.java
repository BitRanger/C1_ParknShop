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

import java.util.List;

import javax.annotation.Nullable;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.model.PsItem;


/**
 * 
 * @author BowenCai
 *
 */
public interface IItemAdService {

	public List<PsPromotItem> forIndexPage(int limit);
	
	public List<PsPromotItem> forItem(@Nullable List<Integer> tags, int category, 
										int limit,
										@Nullable PsCustomer customer);

	List<PsPromotItem> forItemList(List<PsItem> tags, int limit,
			PsCustomer customer);
	
}
