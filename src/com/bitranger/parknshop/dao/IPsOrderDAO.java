package com.bitranger.parknshop.dao;

import java.util.Date;
import java.util.List;


import com.bitranger.parknshop.dao.impl.OrderState;
import com.bitranger.parknshop.model.PsOrder;

public interface IPsOrderDAO {

	public abstract void save(PsOrder transientInstance);
	public abstract void delete(PsOrder persistentInstance);
	public abstract void update(PsOrder detachedInstance);
	
	public abstract PsOrder findByOrderId(Integer id);
	
	public abstract List<PsOrder> findByCustomerId(Integer id, Date from, Date to);
	public abstract List<PsOrder> findByCustomerId(Integer id, OrderState state);
	public abstract List<PsOrder> findByShopId(Integer id, Date from, Date to);
	public abstract List<PsOrder> findByShopId(Integer id, OrderState state);
	
	public abstract List<PsOrder> findAll(OrderState state);
	public abstract List<PsOrder> findAll(Date from, Date to);


}