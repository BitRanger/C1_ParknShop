package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.ROrderItem;
import com.bitranger.parknshop.model.ROrderItemId;

public interface IROrderItemDAO {
	public abstract void save(ROrderItem transientInstance);
	public abstract void delete(ROrderItem persistentInstance);
	public abstract void update(ROrderItem detachedInstance);
	public abstract ROrderItem findById(ROrderItemId id);
	public abstract List<ROrderItem> findByOrderId(Integer id);
}