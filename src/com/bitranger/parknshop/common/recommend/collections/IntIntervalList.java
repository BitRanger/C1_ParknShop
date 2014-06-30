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


import java.io.Serializable;

/**
 * Efficient representation of intervals as an integer list.
 *
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
class IntIntervalList  implements Serializable {
    private static final long serialVersionUID = -914440213158448384L;

    private final int startIndex;
    private final int endIndex;

    /**
     * Create the half-open interval [0,size).
     *
     * @param size The size of the interval.
     */
    IntIntervalList(int size) {
        this(0, size);
    }

    private static void checkIndex(int idx, int start, int end) {
        if (idx < 0 || start + idx >= end) {
            throw new IndexOutOfBoundsException(String.format("%d not in [%d,%d)", idx, start, end));
        }
    }

    /**
     * Create the half-open interval [start,end).
     *
     * @param start The interval start point (inclusive).
     * @param end   The interval end point (exclusive).
     */
    IntIntervalList(int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException("end < start");
        }
        startIndex = start;
        endIndex = end;
    }

    public int getInt(int index) {
        checkIndex(index, startIndex, endIndex);
        return startIndex + index;
    }

    public int size() {
        return endIndex - startIndex;
    }

 
}
