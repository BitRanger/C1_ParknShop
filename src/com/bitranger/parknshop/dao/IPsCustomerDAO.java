package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsCustomer;

public interface IPsCustomerDAO {
	public abstract void save(PsCustomer transientInstance);
	public abstract void delete(PsCustomer persistentInstance);
	public abstract void update(PsCustomer detachedInstance);
	public abstract PsCustomer findByEmail(String email);
	public abstract List<PsCustomer> findAll(Integer limit, Integer offset);
}