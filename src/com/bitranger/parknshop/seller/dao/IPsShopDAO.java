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


import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * 
 * @author BowenCai
 *
 */
public interface IPsShopDAO {
	
	public abstract void save(PsShop transientInstance);
	public abstract void delete(PsShop persistentInstance);
	public abstract void update(PsShop detachedInstance);
	public abstract PsShop findByShopId(Integer id);
	public abstract List<PsShop> findBySellerId(Integer id);
	public abstract List<PsShop> searchByKeyword(String name);
	
	public abstract List<PsShop> findAllSortByVote(FetchOption op);
	public abstract List<PsShop> findAllSortByName(FetchOption op);
	public abstract List<PsShop> findAll();
}
