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

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

import javax.annotation.Nullable;
import java.util.AbstractCollection;
import java.util.Iterator;

public abstract class CopyingFastCollection<E> 
		extends AbstractCollection<E> implements FastCollection<E> {
    private final Function<E, E> copyFunction = new Function<E, E>() {
        @Override
        public E apply(@Nullable E input) {
            return copy(input);
        }
    };

    /**
     * Copy an element.
     *
     */
    protected abstract E copy(E elt);

    @Override
    public Iterator<E> iterator() {
        return Iterators.transform(iterator(), copyFunction);
    }
}
