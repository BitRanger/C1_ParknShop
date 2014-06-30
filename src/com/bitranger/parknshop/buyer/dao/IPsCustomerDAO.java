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

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;

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
