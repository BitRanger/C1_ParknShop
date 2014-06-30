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
import java.util.List;
import java.util.Set;



public abstract class AbstractItemRecommender implements ItemRecommender {


    @Override
	public List<Long> recommend(long user) {
        return recommend(user, -1, null, null);
    }


    @Override
	public List<Long> recommend(long user, int n) {
        return recommend(user, n, null, null);
    }


    @Override
	public List<Long> recommend(long user, Set<Long> candidates) {
        return recommend(user, -1, candidates, null);
    }


    @Override
	public
	abstract List<Long> recommend(long user, int n,
                                                @Nullable Set<Long> candidates,
                                                @Nullable Set<Long> exclude);
    

}
