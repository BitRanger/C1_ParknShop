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

import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;

public interface IPsTagDAO {
	
	public abstract void save(PsTag transientInstance);
	public abstract void delete(PsTag persistentInstance);
	public abstract void update(PsTag detachedInstance);
	
	public abstract List<PsTag> findAll();
	
	/**
	 * 找出这些item的tag的集合
	 * find a set of tags, the tags are used by the list of items
	 * @param items
	 * @return
	 */
	public List<PsTag> findTagsOfItems(List<PsItem> items);
	

	public List<PsTag> selectTopTags(int category, List<String> items);

}
