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
	

	public List<PsTag> selectTopTags(int category, int limit);
	public List<PsTag> selectTopTags(int category, List<String> items);

}
