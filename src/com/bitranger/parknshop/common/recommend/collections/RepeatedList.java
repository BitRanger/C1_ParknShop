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
package com.bitranger.parknshop.common.recommend.collections;

import java.util.AbstractList;

/**
 * List consisting of multiple occurrences of one element.
 *
 * @param <T> The element type of the list.
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
class RepeatedList<T> extends AbstractList<T> {
    private int size;
    private T object;

    /**
     * Construct a new repeated list.
     * @param obj The element.
     * @param sz length of the list.
     */
    public RepeatedList(T obj, int sz) {
        size = sz;
        object = obj;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return object;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
