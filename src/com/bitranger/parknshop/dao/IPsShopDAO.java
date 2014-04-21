package com.bitranger.parknshop.dao;

import java.util.List;


import com.bitranger.parknshop.dao.impl.SortOption;
import com.bitranger.parknshop.model.PsShop;

public interface IPsShopDAO {
	public abstract void save(PsShop transientInstance);
	public abstract void delete(PsShop persistentInstance);
	public abstract void update(PsShop detachedInstance);
	public abstract PsShop findByShopId(Integer id);
	public abstract List<PsShop> findBySellerId(Integer id);
	public abstract List<PsShop> searchByKeyword(String name);
	
	public abstract List<PsShop> findAllSortByVote(SortOption op);
	public abstract List<PsShop> findAllSortByName(SortOption op);
}