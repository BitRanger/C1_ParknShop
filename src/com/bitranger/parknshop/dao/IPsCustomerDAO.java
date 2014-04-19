package org.example.model.dao;

import java.util.List;

import org.example.model.PsCustomer;

public interface IPsCustomerDAO {
	public abstract void save(PsCustomer transientInstance);

	public abstract void delete(PsCustomer persistentInstance);

	public abstract PsCustomer findByEmail(String email);

	public abstract List<PsCustomer> findAll(Integer limit, Integer offset);

	public abstract PsCustomer merge(PsCustomer detachedInstance);

}