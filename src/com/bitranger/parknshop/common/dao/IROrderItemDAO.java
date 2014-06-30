/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.common.dao;

import java.util.List;

import com.bitranger.parknshop.common.model.ROrderItem;
import com.bitranger.parknshop.common.model.ROrderItemId;

public interface IROrderItemDAO {
	public abstract void save(ROrderItem transientInstance);
	public abstract void delete(ROrderItem persistentInstance);
	public abstract void update(ROrderItem detachedInstance);
	public abstract ROrderItem findById(ROrderItemId id);
	public abstract List<ROrderItem> findByOrderId(Integer id);
}
