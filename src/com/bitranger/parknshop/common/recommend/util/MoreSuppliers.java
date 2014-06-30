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
