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

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.util.Iterator;

class FilteringFastIterable<E> implements FastIterable<E> {
    private final Iterable<E> delegate;
    private final Predicate<? super E> predicate;
    private final int limit;

    public FilteringFastIterable(Iterable<E> iter, Predicate<? super E> pred, int limit) {
        delegate = iter;
        predicate = pred;
        this.limit = limit;
    }

    @Override
    public Iterator<E> fastIterator() {
        if (delegate instanceof FastIterable) {
            // REVIEW Is Iterators.filter really reasonable?
            Iterator<E> iter = Iterators.filter(((FastIterable<E>) delegate).fastIterator(), predicate);
            return limit(iter);
        } else {
            return iterator();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return limit(Iterators.filter(delegate.iterator(), predicate));
    }

    private Iterator<E> limit(Iterator<E> iter) {
        if (limit >= 0) {
            return null; //Iterators.limit(iter, limit);
        } else {
            return iter;
        }
    }
}
