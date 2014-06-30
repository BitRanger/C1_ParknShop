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



public final class IdMeanAccumulator {
    private double globalSum;
    private int globalCount;

  
    public void put(long id, double val) {
        globalSum += val;
        globalCount += 1;
    }

    public double globalMean() {
        return globalSum / globalCount;
    }


}
