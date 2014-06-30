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

import com.bitranger.parknshop.common.model.PsItemInfo;

public interface IPsItemInfoDAO {

	public abstract void update(PsItemInfo detachedInstance);
	
	public abstract void save(PsItemInfo transientInstance);

	public abstract void delete(PsItemInfo persistentInstance);

	public abstract List<PsItemInfo> findByItemId(java.lang.Integer id);

}
