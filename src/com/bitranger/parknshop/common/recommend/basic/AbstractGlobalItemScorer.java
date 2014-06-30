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

import java.util.Collection;

import javax.annotation.Nonnull;

import org.apache.commons.lang.NotImplementedException;



public abstract class AbstractGlobalItemScorer {

    public double globalScore(@Nonnull Collection<Long> queryItems, long item) {
    	throw new NotImplementedException();
    }

}
