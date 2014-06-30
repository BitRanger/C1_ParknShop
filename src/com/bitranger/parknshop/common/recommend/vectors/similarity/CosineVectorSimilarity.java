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


public abstract class CosineVectorSimilarity implements VectorSimilarity, Serializable {
    private static final long serialVersionUID = 1L;

    private final double dampingFactor;

    /**
     * Construct an undamped cosine similarity function.
     */
    public CosineVectorSimilarity() {
        this(0.0);
    }

    public CosineVectorSimilarity(double damping) {
        dampingFactor = damping;
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
        return String.format("cosine[d=%s]", dampingFactor);
    }
}
