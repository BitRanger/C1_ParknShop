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
package com.bitranger.parknshop.common.recommend.basic;


import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public abstract class AbstractGlobalItemRecommender  {


    public List<Long> globalRecommend(Set<Long> items, @Nullable Set<Long> candidates) {
    	items.retainAll(candidates);
        List<Long> l = new ArrayList<Long>();
        l.addAll(items);
        return l;
    }

 
    protected abstract List<Long> globalRecommend(Set<Long> items, int n,
                                                      @Nullable Set<Long> candidates,
                                                      @Nullable Set<Long> exclude);

}
