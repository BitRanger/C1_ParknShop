/*******************************************************************************
 * Copyright (c) 2014 BitRanger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     BitRanger - initial API and implementation
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