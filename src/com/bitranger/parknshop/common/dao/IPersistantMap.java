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
import java.util.Set;


import javax.annotation.Nullable;


/**
 *@author BowenCai
 *@since 9:23:56 PM
 */
public interface IPersistantMap {

	public boolean containsKey(String key);

	@Nullable
	public Object get(String key);

	public void put(String key, Object value);

	/**
	 * 
	 * @param key
	 * @return null if failed
	 */
	@Nullable
	public Object remove(String key);

	public Set<String> keySet();
	
}
