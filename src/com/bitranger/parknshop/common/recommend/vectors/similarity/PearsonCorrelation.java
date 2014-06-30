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

import org.apache.commons.lang3.tuple.Pair;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.sqrt;


/**
 * 
 * @author BowenCai
 *
 */
public class PearsonCorrelation implements VectorSimilarity, Serializable {
    private static final long serialVersionUID = 1L;

    private final double shrink_age;

    public PearsonCorrelation() {
        this(0);
    }

    @Inject
    public PearsonCorrelation(@SimiDamping double s) {
        shrink_age = s;
    }

    @Override
	public double similarity(ArrayList<Long> vec1, ArrayList<Long> vec2) {
        if (vec1.isEmpty() || vec2.isEmpty()) {
            return 0;
        }

        // first compute means of common items
        double sum1 = 0;
        double sum2 = 0;
        int n = 0;
        for (Pair<VectorEntry,VectorEntry> pair: Vectors.fastIntersect(vec1, vec2)) {
            sum1 += pair.getLeft().getValue();
            sum2 += pair.getRight().getValue();
            n += 1;
        }

        if (n == 0) {
            return 0;
        }

        final double mu1 = sum1 / n;
        final double mu2 = sum2 / n;

        double var1 = 0;
        double var2 = 0;
        double dot = 0;
        int nCoratings = 0;

        for (Pair pair: Vectors.fastIntersect(vec1, vec2)) {
            final double v1 = (double) pair.getLeft();
            final double v2 = (double) pair.getRight();
            var1 += v1 * v1;
            var2 += v2 * v2;
            dot += v1 * v2;
            nCoratings += 1;
        }

        if (nCoratings == 0) {
            return 0;
        } else {
            return dot / (sqrt(var1 * var2) + shrink_age);
        }
    }

    @Override
    public boolean isSparse() {
        return true;
    }

    @Override
    public boolean isSymmetric() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Pearson[d=%s]", shrink_age);
    }
}
