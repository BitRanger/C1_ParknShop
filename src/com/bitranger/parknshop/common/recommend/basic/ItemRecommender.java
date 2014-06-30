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

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

public interface ItemRecommender {


    List<Long> recommend(Feature feature);
    List<Long> recommend(long user);

    List<Long> recommend(long user, int n);

    List<Long> recommend(long user, @Nullable Set<Long> candidates);

    List<Long> recommend(long user, int n, @Nullable Set<Long> candidates,
                             @Nullable Set<Long> exclude);
}
