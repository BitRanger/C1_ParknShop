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
