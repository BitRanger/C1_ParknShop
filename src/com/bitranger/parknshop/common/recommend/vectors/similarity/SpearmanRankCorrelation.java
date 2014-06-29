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


import javax.inject.Inject;

import com.google.common.primitives.Doubles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public abstract class SpearmanRankCorrelation implements VectorSimilarity, Serializable {
    private static final long serialVersionUID = 3023239202579332883L;

    private final PearsonCorrelation pearson;

    @Inject
    public SpearmanRankCorrelation(@SimiDamping double damping) {
        pearson = new PearsonCorrelation(damping);
    }


    static ArrayList<Long> rank(final ArrayList<Long> vec) {
    	Long[] ids = (Long[]) vec.toArray();
        // sort ID set by value (decreasing)
        Arrays.sort(ids);

        final int n = ids.length;
        final double[] values = new double[n];
        ArrayList<Long> rank = (ArrayList<Long>) vec.clone();
        // assign ranks to each item
        for (int i = 0; i < n; i++) {
            rank.set(i + 1, ids[i]);
            values[i] = vec.get(ids[i].intValue());
        }

        // average ranks for items with same values
        int i = 0;
        while (i < n) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (values[j] != values[i]) {
                    break;
                }
            }
            if (j - i > 1) {
                double r2 = (rank.get(ids[i].intValue()) 
                + rank.get(ids[j - 1].intValue())) / (j - i);
                for (int k = i; k < j; k++) {
                    rank.set(ids[k].intValue(), (long) r2);
                }
            }
            i = j;
        }

        // Make a sparse vector out of it
        return rank;
    }

    @Override
    public double similarity(ArrayList<Long> vec1, ArrayList<Long> vec2) {
        return pearson.similarity(rank(vec1), rank(vec2));
    }

    @Override
    public boolean isSparse() {
        return true;
    }

    @Override
    public boolean isSymmetric() {
        return true;
    }
}
