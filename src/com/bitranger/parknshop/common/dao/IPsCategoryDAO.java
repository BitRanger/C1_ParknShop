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

import com.bitranger.parknshop.common.model.PsCategory;

public interface IPsCategoryDAO {

	public List<PsCategory> findAll();
	
	public abstract void save(PsCategory transientInstance);

	public abstract void delete(PsCategory persistentInstance);

	public abstract List<PsCategory> findAll(FetchOption option);

	public abstract void update(PsCategory detachedInstance);
}
