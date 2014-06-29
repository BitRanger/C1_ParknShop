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
package com.bitranger.parknshop.common.dao;

import java.util.List;

import com.bitranger.parknshop.common.model.PsItem;

public interface IPsItemDAO {


	public List<PsItem> selectBestSellers(int categoryID, int limit);

	public List<PsItem> selectLatest(int categoryID, int limit);

	public List<PsItem> findAll();
	public abstract List<PsItem> findByCountPurchase(FetchOption op);
	public abstract List<PsItem> findByCountFavourite(FetchOption op);
	
	
	public abstract void save(PsItem transientInstance);
	public abstract void delete(PsItem persistentInstance);
	public abstract void update(PsItem detachedInstance);

	public abstract PsItem findById(Integer id);

	/**
	 * search item description in database
	 * @param keyword
	 * @return
	 */
	public abstract List<PsItem> searchByKeyword(String keyword);
	
	/**
	 * sort by price
	 * @param psCategoryId
	 * @param priceMin
	 * @param priceMax
	 * @param op
	 * @return
	 */
	public abstract List<PsItem> findByPriceInCategory(Integer psCategoryId, 
											Double priceMin, Double priceMax, 
											FetchOption option);
	
	public abstract List<PsItem> findByCountPurchaseInCategory(
								Integer psCategoryId, FetchOption op);
	
	public abstract List<PsItem> findByCountFavouriteInCategory(Integer psCategoryId, 
									FetchOption op);
	
	public abstract List<PsItem> findByVoteInCategory(Integer psCategoryId, 
														FetchOption op);
	
	public abstract List<PsItem> findByPriceInTag(Integer psTagId, 
											Double priceMin, Double priceMax, 
											FetchOption op);
	
	public abstract List<PsItem> findByCountPurchaseInTag(Integer psTagId, 
														FetchOption op);
	public abstract List<PsItem> findByCountFavouriteInTag(Integer psTagId, FetchOption op);
	public abstract List<PsItem> findByVoteInTag(Integer psTagId, FetchOption op);
	
	public abstract List<PsItem> findByOrderId(Integer id);
	
	public List<PsItem> findBySeller(Integer sellerId, FetchOption fetchOption);
	
	public List<PsItem> findByShop(Integer shopId, FetchOption fetchOption);
	

}
