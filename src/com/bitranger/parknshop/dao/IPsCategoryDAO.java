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
package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsCategory;

public interface IPsCategoryDAO {

	public abstract void save(PsCategory transientInstance);

	public abstract void delete(PsCategory persistentInstance);

	public abstract List<PsCategory> findAll(Integer limit, Integer offset);

	public abstract void update(PsCategory detachedInstance);
}
