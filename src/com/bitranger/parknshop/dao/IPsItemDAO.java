package org.example.model.dao;

import java.util.List;

import org.example.model.PsItem;

public interface IPsItemDAO {

	public abstract void save(PsItem transientInstance);
	public abstract void delete(PsItem persistentInstance);
	public abstract PsItem update(PsItem detachedInstance);

	public abstract PsItem findById(Integer id);
	public abstract List<PsItem> findByKeyword(String keyword);
	
	public abstract List<PsItem> findByPriceInCategory(Integer psCategoryId, Double priceMin, Double priceMax, SortOption op);
	public abstract List<PsItem> findByCountPurchaseInCategory(Integer psCategoryId, SortOption op);
	public abstract List<PsItem> findByCountFavouriteInCategory(Integer psCategoryId, SortOption op);
	public abstract List<PsItem> findByVoteInCategory(Integer psCategoryId, SortOption op);
	
	public abstract List<PsItem> findByPriceInTag(Integer psTagId, Double priceMin, Double priceMax, SortOption op);
	public abstract List<PsItem> findByCountPurchaseInTag(Integer psTagId, SortOption op);
	public abstract List<PsItem> findByCountFavouriteInTag(Integer psTagId, SortOption op);
	public abstract List<PsItem> findByVoteInTag(Integer psTagId, SortOption op);
	
	public abstract List<PsItem> findAllByCountPurchase(SortOption op);
	public abstract List<PsItem> findAllByCountFavourite(SortOption op);
}