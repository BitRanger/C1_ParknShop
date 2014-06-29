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
