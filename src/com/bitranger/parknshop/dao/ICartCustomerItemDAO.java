package org.example.model.dao;

import java.util.List;

import org.example.model.*;

public interface ICartCustomerItemDAO {

	public abstract void save(CartCustomerItem transientInstance);

	public abstract void delete(CartCustomerItem persistentInstance);

	public abstract CartCustomerItem findById(CartCustomerItemId id);

	public abstract List<PsItem> findByCustomerId(Integer psCustomerId, Integer limit, Integer offset);

	public abstract void update(CartCustomerItem detachedInstance);
}