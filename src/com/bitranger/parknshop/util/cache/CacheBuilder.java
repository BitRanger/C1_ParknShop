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

/**
 * build cache value
 * 
 * @author BowenCai
 * @see SimpleCache
 * @see WeakCache
 *
 * @param <V>
 */
public interface CacheBuilder<V> {
	public V build();
}
