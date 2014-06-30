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
package com.bitranger.parknshop.buyer.dao;

import java.util.List;

import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.CartCustomerItemId;
import com.bitranger.parknshop.common.dao.FetchOption;

public interface ICartCustomerItemDAO {

	public void save(CartCustomerItem transientInstance);

	public void delete(CartCustomerItem persistentInstance);
	
	public void deleteAll(List<CartCustomerItem> items);

	public CartCustomerItem findById(CartCustomerItemId id);

	public List<CartCustomerItem> findByCustomerId(Integer psCustomerId, FetchOption option);

	public void update(CartCustomerItem detachedInstance);
}
