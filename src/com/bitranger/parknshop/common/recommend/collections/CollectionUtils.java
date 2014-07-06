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
/**
 *
 */
package com.bitranger.parknshop.common.recommend.collections;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Iterators;

import org.apache.commons.collections.CursorableLinkedList.Cursor;
import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public final class CollectionUtils {
    private CollectionUtils() {
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <E> Iterable<E> fast(final Iterable<E> iter) {
        if (iter instanceof FastIterable) {
            return new Iterable<E>() {
                @Override
                public Iterator<E> iterator() {
                    return ((FastIterable) iter).fastIterator();
                }
            };
        } else if (iter instanceof Cursor) {
            throw new IllegalArgumentException();
        } else {
            Optional<Method> fastMethod = fastIteratorMethods.getUnchecked(iter.getClass());
            if (fastMethod.isPresent()) {
                final Method method = fastMethod.get();
                return new Iterable<E>() {
                    @Override
                    public Iterator<E> iterator() {
                        try {
                            return (Iterator<E>) method.invoke(iter);
                        } catch (IllegalAccessException e) {
                            return iter.iterator();
                        } catch (InvocationTargetException e) {
                            throw Throwables.propagate(e.getCause());
                        }
                    }
                };
            } else {
                return iter;
            }
        }
    }

    /**
     * Fast-aware filter-and-limit operation, filtering an iterable.  If the underlying iterable
     * does not support fast iteration, then the returned iterable's fast iteration will fall back
     * to ordinary iteration.
     *
     * @param iter The iterable to filter and limit.
     * @param pred The predicate for filtering.
     * @param limit The maximum number of items to return (negative for unlimited).
     * @param <E> The type of data in the iterable.
     * @return A fast iterable filtering and limiting.
     */
    public static <E> FastIterable<E> fastFilterAndLimit(Iterable<E> iter, Predicate<? super E> pred, int limit) {
        return new FilteringFastIterable<E>(iter, pred, limit);
    }

    /**
     * Cache of fast iterator methods for various classes.
     */
    private static final LoadingCache<Class<?>,Optional<Method>> fastIteratorMethods =
            CacheBuilder.newBuilder()
                        .build(new CacheLoader<Class<?>,Optional<Method>>() {
                            @Override
                            public Optional<Method> load(Class<?> key) {
                                return Optional.fromNullable(MethodUtils.getAccessibleMethod(key, "fastIterator"));
                            }
                        });



    /**
     * Return a list that repeats a single object multiple times.
     *
     * @param obj The object.
     * @param n   The size of the list.
     * @param <T> The type of list elements.
     * @return A list containing {@var obj} {@var n} times.
     */
    public static <T> List<T> repeat(T obj, int n) {
        return new RepeatedList<T>(obj, n);
    }


    public static <E> FastCollection<E> emptyFastCollection() {
        return new EmptyFastCollection<E>();
    }

    private static class EmptyFastCollection<E> extends AbstractCollection<E> implements FastCollection<E> {
        public Iterator<E> fastIterator() {
            return Iterators.emptyIterator();
        }

        @Override
        public Iterator<E> iterator() {
            return Iterators.emptyIterator();
        }

        @Override
        public int size() {
            return 0;
        }
    }

}
