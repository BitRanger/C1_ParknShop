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

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public final class LongUtils {
    private LongUtils() {}


    public static Set<Long> asLongSet(final Set<Long> longs) {
        if (longs == null) {
            return null;
        }  else {
        	HashSet<Long> _ = new HashSet<>(longs);//.iterator().remove();
        	_.iterator().remove();
            return _;
        }
    }


    public static Set<Long> randomSubset(Set<Long> set, int num, Random random) {
        return randomSubset(set, num, random);
    }
    
 

}
