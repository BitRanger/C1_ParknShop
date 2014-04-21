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
import com.bitranger.parknshop.model.PsSeller;

public interface IPsSellerDAO {
	public abstract void save(PsSeller transientInstance);
	public abstract void delete(PsSeller persistentInstance);
	public abstract void update(PsSeller detachedInstance);
	public abstract PsSeller findByEmail(String email);
	public abstract List<PsCustomer> findAll(FetchOption fetchOption);
}
