package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsTag;

public interface IPsTagDAO {
	public abstract void save(PsTag transientInstance);
	public abstract void delete(PsTag persistentInstance);
	public abstract void update(PsTag detachedInstance);
	public abstract List<PsTag> findAll();
}