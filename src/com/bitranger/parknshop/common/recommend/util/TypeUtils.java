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

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import javax.annotation.Nullable;

public class TypeUtils {
 
    public static <T> Set<Class<? extends T>>
    findTypes(Iterable<? extends T> objects, Class<T> parent) {
        Set<Class<? extends T>> objTypes =
                Sets.newHashSet(transform(objects, extractClass(parent)));

        Set<Class<? extends T>> allTypes = new HashSet<Class<? extends T>>();
        for (Class<? extends T> t : objTypes) {
            addAll(allTypes, transform(filter(typeClosure(t), isSubclass(parent)),
                                       asSubclass(parent)));
        }
        return allTypes;
    }

    public static Set<Class<?>> typeClosure(Class<?> type) {
        if (type == null) {
            return Collections.emptySet();
        }

        Set<Class<?>> supertypes = new HashSet<Class<?>>();
        supertypes.add(type);
        supertypes.addAll(typeClosure(type.getSuperclass()));
        for (Class<?> iface : type.getInterfaces()) {
            supertypes.addAll(typeClosure(iface));
        }

        return supertypes;
    }

    public static Predicate<Class<?>> isSubclass(final Class<?> cls) {
        return new Predicate<Class<?>>() {

            @Override
            public boolean apply(Class<?> input) {
                return cls.isAssignableFrom(input);
            }
        };
    }

    /**
     * Function that casts classes to specified types.  This function does not accept nulls.
     *
     * @param supertype A class known to be a valid supertype for any argument.
     */
    public static <T> Function<Class<?>, Class<? extends T>> asSubclass(final Class<T> supertype) {
        return new Function<Class<?>, Class<? extends T>>() {
            @Override
            public Class<? extends T> apply(Class<?> input) {
                if (input == null) {
                    throw new NullPointerException("null class");
                } else {
                    return input.asSubclass(supertype);
                }
            }
        };
    }

    /**
     * Function that gets the class for its argument.
     * @param supertype A class known to be a valid supertype for any argument.
     * @param acceptNull Whether nulls are accepted &amp; passed through. If {@code false}, the function
     *                   will never return {@code null}.
     */
    public static <T> Function<T, Class<? extends T>> extractClass(final Class<T> supertype, final boolean acceptNull) {
        return new Function<T, Class<? extends T>>() {
            @Override
            public Class<? extends T> apply(@Nullable T input) {
                if (input != null) {
                    return input.getClass().asSubclass(supertype);
                } else if (acceptNull) {
                    return null;
                } else {
                    throw new NullPointerException();
                }
            }
        };
    }

    /**
     * Function that gets the class for its argument.  This function does not accept nulls.
     *
     * @param supertype A class known to be a valid supertype for any argument.
     */
    public static <T> Function<T, Class<? extends T>> extractClass(final Class<T> supertype) {
        return extractClass(supertype, false);
    }

    /**
     * Function that gets the class for its argument.
     */
    public static Function<Object, Class<?>> extractClass() {
        return extractClass(Object.class);
    }

    /**
     * Function that gets the class for its argument.
     */
    public static Function<Object, Class<?>> extractClass(boolean acceptNull) {
        return extractClass(Object.class, acceptNull);
    }

    /**
     * A predicate that accepts classes which are subtypes of (assignable to) the parent class.
     * @param parent The parent class.
     * @return A predicate that returns {@code true} when applied to a subtype of {@code parent}.
     *         That is, it implements {@code paret.isAssignableFrom(type)}.
     */
    public static Predicate<Class<?>> subtypePredicate(final Class<?> parent) {
        return new Predicate<Class<?>>() {
            @Override
            public boolean apply(@Nullable Class<?> input) {
                return parent.isAssignableFrom(input);
            }
        };
    }
}
