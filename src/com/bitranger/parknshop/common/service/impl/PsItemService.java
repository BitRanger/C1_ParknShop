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
package com.bitranger.parknshop.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.service.IPsItemService;

public class PsItemService implements IPsItemService {

	@Autowired
	@Qualifier(value="psItemDao")
	PsItemDAO psItemDAO;
	
	@Override
	public List<PsItem> findByCountPurchase(FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountPurchase(op);
	}

	@Override
	public List<PsItem> findByCountFavourite(FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountFavourite(op);
	}

	@Override
	public void save(PsItem transientInstance) {
		// TODO Auto-generated method stub
		psItemDAO.save(transientInstance);
	}

	@Override
	public void delete(PsItem persistentInstance) {
		// TODO Auto-generated method stub
		psItemDAO.delete(persistentInstance);
	}

	@Override
	public void update(PsItem detachedInstance) {
		// TODO Auto-generated method stub
		
		psItemDAO.update(detachedInstance);
	}

	@Override
	public PsItem findById(Integer id) {
		// TODO Auto-generated method stub
		return psItemDAO.findById(id);
	}

	@Override
	public List<PsItem> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return psItemDAO.searchByKeyword(keyword);
	}

	@Override
	public List<PsItem> findByPriceInCategory(Integer psCategoryId,
			Double priceMin, Double priceMax, FetchOption option) {
		// TODO Auto-generated method stub
		return psItemDAO.findByPriceInCategory(psCategoryId, priceMin, priceMax, option);
	}

	@Override
	public List<PsItem> findByCountPurchaseInCategory(Integer psCategoryId,
			FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountPurchaseInCategory(psCategoryId, op);
	}

	@Override
	public List<PsItem> findByCountFavouriteInCategory(Integer psCategoryId,
			FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountFavouriteInCategory(psCategoryId, op);
	}

	@Override
	public List<PsItem> findByVoteInCategory(Integer psCategoryId,
			FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByVoteInCategory(psCategoryId, op);
	}

	@Override
	public List<PsItem> findByPriceInTag(Integer psTagId, Double priceMin,
			Double priceMax, FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByPriceInTag(psTagId, priceMin, priceMax, op);
	}

	@Override
	public List<PsItem> findByCountPurchaseInTag(Integer psTagId, FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountPurchaseInTag(psTagId, op);
	}

	@Override
	public List<PsItem> findByCountFavouriteInTag(Integer psTagId,
			FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByCountFavouriteInTag(psTagId, op);
	}

	@Override
	public List<PsItem> findByVoteInTag(Integer psTagId, FetchOption op) {
		// TODO Auto-generated method stub
		return psItemDAO.findByVoteInTag(psTagId, op);
	}

	@Override
	public List<PsItem> findByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return psItemDAO.findByOrderId(id);
	}

	@Override
	public List<PsItem> findBySeller(Integer sellerId, FetchOption fetchOption) {
		// TODO Auto-generated method stub
		return psItemDAO.findBySeller(sellerId, fetchOption);
	}

	@Override
	public List<PsItem> findByShop(Integer shopId, FetchOption fetchOption) {
		// TODO Auto-generated method stub
		return psItemDAO.findByShop(shopId, fetchOption);
	}

	public PsItemDAO getPsItemDAO() {
		return psItemDAO;
	}

	public void setPsItemDAO(PsItemDAO psItemDAO) {
		this.psItemDAO = psItemDAO;
	}

	
	
}
