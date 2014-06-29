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
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public final class Functional {
    private Functional() {}

    public static <T> Function<Pair<T,?>,T> pairLeft() {
        return new Function<Pair<T, ?>, T>() {
            @Nullable
            @Override
            public T apply(@Nullable Pair<T, ?> input) {
                if (input == null) {
                    return null;
                } else {
                    return input.getLeft();
                }
            }
        };
    }

    public static <T> Function<Pair<?, T>,T> pairRight() {
        return new Function<Pair<?, T>, T>() {
            @Nullable
            @Override
            public T apply(@Nullable Pair<?, T> input) {
                if (input == null) {
                    return null;
                } else {
                    return input.getRight();
                }
            }
        };
    }

    public static <T> Function<T, Object> invokeMethod(final Method method, final Object target) {
        return new Function<T, Object>() {
            @Nullable
            @Override
            public Object apply(@Nullable T input) {
                try {
                    return method.invoke(target, input);
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return input;
            }
        };
    }

    public static <F, T> Function<F, T> cast(final Class<T> target) {
        return new Function<F, T>() {
            @Override
            public T apply(F obj) {
                return target.cast(obj);
            }
        };
    }

}
