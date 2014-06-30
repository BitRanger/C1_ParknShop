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

import javax.annotation.Nonnull;

import org.apache.commons.lang.NotImplementedException;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Base class to make item scorers easier to implement. Delegates all score methods to
 * {@link #score(long, MutableSparseVector)}.
 *
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
public abstract class AbstractItemScorer implements ItemListener {
  

    public List<Double> score(long user, @Nonnull Collection<Long> items) {
    	return Arrays.asList(score(user, items.iterator().next()));
    }

    public double score(long user, long item) {
    	throw new NotImplementedException();
    }
}
