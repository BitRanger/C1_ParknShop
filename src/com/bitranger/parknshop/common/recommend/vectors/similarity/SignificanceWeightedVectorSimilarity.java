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
