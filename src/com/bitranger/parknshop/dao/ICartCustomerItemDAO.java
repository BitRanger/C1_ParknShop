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

import java.util.List;

import com.bitranger.parknshop.model.CartCustomerItem;
import com.bitranger.parknshop.model.CartCustomerItemId;

public interface ICartCustomerItemDAO {

	public void save(CartCustomerItem transientInstance);

	public void delete(CartCustomerItem persistentInstance);

	public CartCustomerItem findById(CartCustomerItemId id);

	public List<CartCustomerItem> findByCustomerId(Integer psCustomerId, FetchOption option);

	public void update(CartCustomerItem detachedInstance);
}
