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


import java.util.List;


public final class TopNScoredItemAccumulator  {
    private final int count;
    private int slot;
    // The current size.
    private int size;


    public TopNScoredItemAccumulator(int n) {
        this.count = n;

        slot = 0;
        size = 0;

        // heap must have n+1 slots to hold extra item before removing smallest

        // item lists are lazy-allocated
    }


    private static int findInitialSize(int maxSize) {
        int best = 10;
        int overhead = maxSize;
        for (int i = 10; i <= 25; i++) {
            int cap = i;
            while (cap < maxSize) {
                cap *= 2;
            }
            int ovh = maxSize - cap;
            if (ovh < overhead) {
                overhead = ovh;
                best = i;
            }
        }
        return best;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
