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
package com.bitranger.parknshop.seller.dao;

import java.util.List;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.seller.model.PsSeller;

public interface IPsSellerDAO {
	public abstract void save(PsSeller transientInstance);

	public PsSeller findById(Integer id);
	
	public abstract void delete(PsSeller persistentInstance);
	public abstract void update(PsSeller detachedInstance);
	public abstract PsSeller findByEmail(String email);
	public abstract List<PsSeller> findAll(FetchOption fetchOption);
}
