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
package com.bitranger.parknshop.common.service;

import java.util.List;

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.model.PsItem;

public interface IPsItemService {

	public abstract List<PsItem> findByCountPurchase(FetchOption op);

	public abstract List<PsItem> findByCountFavourite(FetchOption op);

	public abstract void save(PsItem transientInstance);

	public abstract void delete(PsItem persistentInstance);

	public abstract void update(PsItem detachedInstance);

	public abstract PsItem findById(Integer id);

	public abstract List<PsItem> searchByKeyword(String keyword);

	public abstract List<PsItem> findByPriceInCategory(Integer psCategoryId,
			Double priceMin, Double priceMax, FetchOption option);

	public abstract List<PsItem> findByCountPurchaseInCategory(
			Integer psCategoryId, FetchOption op);

	public abstract List<PsItem> findByCountFavouriteInCategory(
			Integer psCategoryId, FetchOption op);

	public abstract List<PsItem> findByVoteInCategory(Integer psCategoryId,
			FetchOption op);

	public abstract List<PsItem> findByPriceInTag(Integer psTagId,
			Double priceMin, Double priceMax, FetchOption op);

	public abstract List<PsItem> findByCountPurchaseInTag(Integer psTagId,
			FetchOption op);

	public abstract List<PsItem> findByCountFavouriteInTag(Integer psTagId,
			FetchOption op);

	public abstract List<PsItem> findByVoteInTag(Integer psTagId, FetchOption op);

	public abstract List<PsItem> findByOrderId(Integer id);

	public List<PsItem> findBySeller(Integer sellerId, FetchOption fetchOption);

	public List<PsItem> findByShop(Integer shopId, FetchOption fetchOption);

}
