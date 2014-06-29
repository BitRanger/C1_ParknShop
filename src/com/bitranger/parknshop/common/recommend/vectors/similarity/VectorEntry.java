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
package com.bitranger.parknshop.common.recommend.vectors.similarity;

import com.google.common.base.Function;

import javax.annotation.Nullable;


public final class VectorEntry implements Cloneable {


    public static enum State {
        /**
         * A set entry.
         */
        SET,
        UNSET,
        EITHER
    }

    @Nullable
    private int index;
    private long key;
    private double value;
    private boolean isSet;


    /**
     * Get the key at this entry.
     *
     * @return The key of this entry.
     */
    public long getKey() {
        return key;
    }

    /**
     * Get the value at this entry.
     *
     * @return The value of this entry.
     */
    public double getValue() {
        return value;
    }

    /**
     * Internal method to get associated index, if specified.
     *
     * @return The index into the vector of this entry.
     */
    int getIndex() {
        return index;
    }

    /**
     * Query whether this entry is set.
     *
     * @return {@code true} if the entry's key is in the key set; {@code false} if
     *         it is only in the key domain.
     */
    public boolean isSet() {
        return isSet;
    }

    /**
     * Update the entry (used for fast iteration).
     *
     * @param i The new index.
     * @param k The new key.
     * @param v the new value.
     * @param set Whether the entry is set.
     */
    void set(int i, long k, double v, boolean set) {
        index = i;
        key = k;
        value = v;
        isSet = set;
    }

    /**
     * Update the value. Used only to implement {@link MutableSparseVector#set(VectorEntry, double)}.
     *
     * @param v The new value
     */
    void setValue(double v) {
        value = v;
    }


    @Override
    public VectorEntry clone() {
        VectorEntry e;
        try {
            e = (VectorEntry) super.clone();
        } catch (CloneNotSupportedException exc) {
            throw new AssertionError(exc); // This cannot happen
        }
        return e;
    }
    
    @Override
    public String toString() {
        return "VectorEntry:"
                + " index=" + index
                + " key=" + key 
                + " value=" + value
                + " isSet=" + isSet;
    }

    /**
     * A function that copies (clones) vector entries.
     * @return A function that copies vector entries.
     */
    static Function<VectorEntry, VectorEntry> copyFunction() {
        return CopyFunction.INSTANCE;
    }
    private static enum CopyFunction implements Function<VectorEntry,VectorEntry> {
        INSTANCE;

        @Nullable
        @Override
        public VectorEntry apply(@Nullable VectorEntry input) {
            if (input == null) {
                return null;
            } else {
                return input.clone();
            }
        }

    }
}
