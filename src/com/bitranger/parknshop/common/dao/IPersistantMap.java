package com.bitranger.parknshop.common.dao;

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
