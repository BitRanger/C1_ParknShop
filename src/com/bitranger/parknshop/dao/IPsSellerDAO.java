package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsCustomer;
import com.bitranger.parknshop.model.PsSeller;

public interface IPsSellerDAO {
	public abstract void save(PsSeller transientInstance);
	public abstract void delete(PsSeller persistentInstance);
	public abstract void update(PsSeller detachedInstance);
	public abstract PsSeller findByEmail(String email);
	public abstract List<PsCustomer> findAll(Integer limit, Integer offset);
}