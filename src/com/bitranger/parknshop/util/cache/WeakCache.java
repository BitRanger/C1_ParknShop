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

import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


/**
 * A weak and lazy cache.
 * 
 * Weak map with weak ref to the value
 * 
 * the map is transient, and will be inited only if put is called
 * 
 * @author BowenCai
 *
 * @param <K>
 * @param <V>
 */
public final class WeakCache<K, V> implements Serializable {

	public transient WeakHashMap<K, WeakReference<V>> map = new WeakHashMap<K, WeakReference<V>>();
	
	public boolean contains(K key) {
		if (map == null) {
			return false;
		}
		return map.get(key) == null;
	}
	
	public V get(K key) {
		if (map == null) {
			return null;
		}
		WeakReference<V> reference = this.map.get(key);
		if (reference == null) {
			return null;
		}
		V value = reference.get();
		if (value == null) {
			this.map.remove(key);
		}
		return value;
	}
	
	public V get(K key, CacheBuilder<V> builder) {
		if (map == null) {
			map = new WeakHashMap<K, WeakReference<V>>();
			V var = builder.build();
			synchronized (map) {
				map.put(key, new WeakReference<V>(var));	
			}
			return var;
		}
		
		WeakReference<V> reference = this.map.get(key);
		V value;
		if (reference == null) {
			value = builder.build();
			synchronized (map) {
				map.put(key, new WeakReference<V>(value));	
			}
			return value;
		} else {
			value = reference.get();
			if (value == null) {
				value = builder.build();
				synchronized (map) {
					this.map.put(key, new WeakReference<V>(value));	
				}
			}
			return value;	
		}
	}
	
	public void put(K key, V value) {
		if (map == null) {
			map = new WeakHashMap<K, WeakReference<V>>();
			synchronized (map) {
				this.map.put(key, new WeakReference<V>(value));	
			}			
			return;
		}
		if (value != null) {
			synchronized (map) {
				this.map.put(key, new WeakReference<V>(value));	
			}
		} else {
			this.map.remove(key);
		}
	}

	public void clear() {
		if (map != null) {
			synchronized (map) {
				map.clear();
			}
		}
	}
	
	private static final long serialVersionUID = -6185273794143193982L;
	
	private void writeObject(java.io.ObjectOutputStream s) throws IOException {
		// first, put all valid entries to a hashmap
		HashMap<K, V> tmp = new HashMap<>(this.map.size());
		for (Map.Entry<K, WeakReference<V>> entry : this.map.entrySet()) {
			K k = entry.getKey();
			if (k != null) {
				WeakReference<V> ref = entry.getValue();
				if (ref != null && ref.get() != null) {
					tmp.put(entry.getKey(), entry.getValue().get());
				}
			}
		}
		s.defaultWriteObject();
		s.writeInt(tmp.size());
		for (Map.Entry<K, V> e : tmp.entrySet()) {
			s.writeObject(e.getKey());
			s.writeObject(e.getValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		this.map = new WeakHashMap<K, WeakReference<V>>();
		s.defaultReadObject();
		int sz = s.readInt();
		for (int i = 0; i < sz; i++) {
			K k = (K) s.readObject();
			V v = (V) s.readObject();
			this.map.put(k, new WeakReference<V>(v));
		}
	}
}
