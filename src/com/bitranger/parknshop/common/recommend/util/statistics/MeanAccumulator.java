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

package com.bitranger.parknshop.common.recommend.util.statistics;


public class MeanAccumulator {

    private double accSum;
    private long accCount;

    /**
     * Construct a new, zeroed average accumulator.
     */
    public MeanAccumulator() {
        accCount = 0;
        accSum = 0;
    }

    /**
     * Initialize the {@link MeanAccumulator} with a pre-calculated sum and
     * the amount of values included.
     *
     * @param sum   pre-calculated sum
     * @param count amount of values that where used to build this sum
     */
    public MeanAccumulator(double sum, long count) {
        accCount = count;
        accSum = sum;
    }

    /**
     * Add a new datum to the {@link MeanAccumulator}.
     *
     * @param datum new datum to include into the average.
     */
    public void add(double datum) {
        accSum += datum;
        accCount++;
    }

    /**
     * @return average over all added datums
     */
    public double getMean() {
        if (accCount == 0 || accSum == 0) {
            return 0;
        }

        return accSum / accCount;
    }

    /**
     * Get the total of the values accumulated so far.
     * @return The total of the values.
     */
    public double getTotal() {
        return accSum;
    }

    /**
     * @return amount of values this average is based on
     */
    public long getCount() {
        return accCount;
    }

    @Override
    public String toString() {
        return Double.toString(this.getMean());
    }
}
