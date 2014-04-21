package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsItemInfo;

public interface IPsItemInfoDAO {

	public abstract void update(PsItemInfo detachedInstance);
	
	public abstract void save(PsItemInfo transientInstance);

	public abstract void delete(PsItemInfo persistentInstance);

	public abstract List<PsItemInfo> findByItemId(java.lang.Integer id);

}