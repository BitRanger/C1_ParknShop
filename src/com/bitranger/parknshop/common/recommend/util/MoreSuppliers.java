/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2014 Regents of the University of Minnesota and contributors
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.bitranger.parknshop.common.recommend.util;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public final class MoreSuppliers {
    private MoreSuppliers() {}


    public static <T> Supplier<T> weakMemoize(Supplier<T> supplier) {
        return new WeakMemoizingSupplier<T>(supplier);
    }

    
    public static <T> Supplier<T> softMemoize(Supplier<T> supplier) {
        return new SoftMemoizingSupplier<T>(supplier);
    }

    public static <X,T> Supplier<T> curry(Function<? super X,T> func, X arg) {
        return Suppliers.compose(func, Suppliers.ofInstance(arg));
    }

    private abstract static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 1L;

        private final Supplier<T> delegate;

        private transient volatile Reference<T> cache;

        protected MemoizingSupplier(Supplier<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public synchronized T get() {
            T obj = null;
            if (cache != null) {
                obj = cache.get();
            }
            if (obj == null) {
                obj = delegate.get();
                Preconditions.checkNotNull(obj, "cannot return null");
                cache = makeReference(obj);
            }
            return obj;
        }

        protected abstract Reference<T> makeReference(T obj);

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else if (obj.getClass().equals(getClass())) {
                return delegate.equals(((MemoizingSupplier) obj).delegate);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return delegate.hashCode();
        }
    }

    private static class WeakMemoizingSupplier<T> extends MemoizingSupplier<T> {
        private WeakMemoizingSupplier(Supplier<T> delegate) {
            super(delegate);
        }

        @Override
        protected Reference<T> makeReference(T obj) {
            return new WeakReference<T>(obj);
        }
    }

    private static class SoftMemoizingSupplier<T> extends MemoizingSupplier<T> {
        private SoftMemoizingSupplier(Supplier<T> delegate) {
            super(delegate);
        }

        @Override
        protected Reference<T> makeReference(T obj) {
            return new SoftReference<T>(obj);
        }
    }
}
