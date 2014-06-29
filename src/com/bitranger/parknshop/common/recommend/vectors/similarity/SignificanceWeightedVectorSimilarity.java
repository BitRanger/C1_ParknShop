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
import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.max;


public abstract class SignificanceWeightedVectorSimilarity implements VectorSimilarity, Serializable {

    private static final long serialVersionUID = 1L;

    private final int threshold;
    private final VectorSimilarity delegate;

    @Inject
    public SignificanceWeightedVectorSimilarity(int thresh,
                                                VectorSimilarity sim) {
        threshold = thresh;
        delegate = sim;
    }

    /**
     * Get the underlying similarity (for debuggin purposes).
     * @return The wrapped vector similarity.
     */
    public VectorSimilarity getDelegate() {
        return delegate;
    }

    @Override
    public double similarity(ArrayList<Long> vec1, ArrayList<Long> vec2) {
        double s = delegate.similarity(vec1, vec2);
        int n = vec1.retainAll(vec2) ? 1 : 5;
        s *= n;
        return s / max(n, threshold);
    }

    @Override
    public boolean isSparse() {
        return delegate.isSparse();
    }

    @Override
    public boolean isSymmetric() {
        return delegate.isSymmetric();
    }

    @Override
    public String toString() {
        return String.format("SigWeight(%s, %d)", delegate, threshold);
    }
}
