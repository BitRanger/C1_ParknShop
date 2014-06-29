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
package com.bitranger.parknshop.common.recommend.collections;

import com.google.common.base.Preconditions;

import java.util.BitSet;
import java.util.NoSuchElementException;



/**
 * 
 * @author BowenCai
 *
 */
public final class BitSetIterator  {

    private final int firstBit;
    private final int lastBit;

    private int nextBit;

    private BitSet bitSet;

    public BitSetIterator(BitSet set) {
        this(set, 0);
    }

    public BitSetIterator(BitSet set, int start) {
        this(set, start, set.size());
    }

    public BitSetIterator(BitSet set, int start, int end) {
        this(set, start, end, start);
    }

    public BitSetIterator(BitSet set, int start, int end, int initial) {
        Preconditions.checkArgument(start >= 0, "Starting index must be non-negative");
        Preconditions.checkArgument(start <= end, "Starting index must not be past ending index");
        Preconditions.checkArgument(initial >= start, "initial index must be >= start");
        Preconditions.checkArgument(initial <= end, "initial index must be <= end");
        bitSet = set;
        firstBit = start;
        lastBit = end;
        nextBit = bitSet.nextSetBit(initial);
        if (nextBit < 0) {
            nextBit = lastBit;
        }
    }

    public boolean hasNext() {
        return nextBit >= firstBit && nextBit < lastBit;
    }

    private int previousSetBit(int start) {
        for (int i = start; i >= firstBit; i--) {
            if (bitSet.get(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean hasPrevious() {
        return previousSetBit(nextBit - 1) >= firstBit;
    }

    public int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int retval = nextBit;
        nextBit = bitSet.nextSetBit(nextBit + 1);
        if (nextBit < 0) {
            nextBit = lastBit;
        }
        return retval;
    }

    public int previousInt() {
        int prevBit = previousSetBit(nextBit - 1);
        if (prevBit < 0) {
            throw new NoSuchElementException();
        } 
        nextBit = prevBit;
        return nextBit;
    }
}
