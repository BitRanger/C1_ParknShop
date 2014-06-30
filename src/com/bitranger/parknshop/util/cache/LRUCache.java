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
package com.bitranger.parknshop.util.cache;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * LRU cache based on LinkedHashMap
 * @author BowenCai
 *
 */
public class LRUCache<K,V> implements Serializable {

	private static final long serialVersionUID = 6428478108963526728L;
	
	final int size;
	private final LinkedHashMap<K, V> map = new LinkedHashMap<K, V>(101){
		private static final long serialVersionUID = 7598485345807394732L;
		@Override
	    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
	        return this.size() > LRUCache.this.size;
	    }
	};
	
	public LRUCache(int size) {
		this.size = size;
	}
	public V get(K key) {
		return map.get(key);
	}

	public V get(K k, CacheBuilder<V> builder) {
		V v = map.get(k);
		if (v == null) {
			v = builder.build();
			synchronized (map) {
				map.put(k, v);
			}
		}
		return v;
	}
	
	public void put(K k, V v) {
		synchronized (map) {
			map.put(k, v);
		}
	}

	public void clear() {
		synchronized (map) {
			map.clear();
		}
	}
}
