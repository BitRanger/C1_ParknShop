package com.bitranger.parknshop.common.dao;

import java.util.List;

import javax.annotation.Nullable;


/**
 *@author BowenCai
 *@since 9:23:56 PM
 */
public interface IPersistantMap {

	public boolean containsKey(String key);

	@Nullable
	public <T> T  get(String key);

	public void put(String key, Object value);

	/**
	 * 
	 * @param key
	 * @return null if failed
	 */
	@Nullable
	public void remove(String key);

	public List<String> keys();
	
}
