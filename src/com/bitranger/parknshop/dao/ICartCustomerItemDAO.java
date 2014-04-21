package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.CartCustomerItem;
import com.bitranger.parknshop.model.CartCustomerItemId;
import com.bitranger.parknshop.model.PsItem;

public interface ICartCustomerItemDAO {

	public abstract void save(CartCustomerItem transientInstance);

	public abstract void delete(CartCustomerItem persistentInstance);

	public abstract CartCustomerItem findById(CartCustomerItemId id);

	public abstract List<PsItem> findByCustomerId(Integer psCustomerId, Integer limit, Integer offset);

	public abstract void update(CartCustomerItem detachedInstance);
}