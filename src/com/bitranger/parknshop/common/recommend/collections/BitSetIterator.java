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
