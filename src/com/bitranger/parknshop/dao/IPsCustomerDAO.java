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

import com.bitranger.parknshop.model.PsCustomer;

public interface IPsCustomerDAO {
	
	public abstract void save(PsCustomer transientInstance);
	public abstract void delete(PsCustomer persistentInstance);
	public abstract void update(PsCustomer detachedInstance);

	/**
	 * email is not null and is verified
	 * @param email
	 * @return
	 */
	public abstract PsCustomer findByEmail(String email);
	public abstract List<PsCustomer> findAll(FetchOption option);
}
