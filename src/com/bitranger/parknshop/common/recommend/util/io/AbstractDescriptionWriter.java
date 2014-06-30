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
package com.bitranger.parknshop.common.recommend.util.io;


public abstract class AbstractDescriptionWriter implements DescriptionWriter {
    @Override
    public DescriptionWriter putField(String name, Object value) {
        return putField(name, value, Descriptions.defaultDescriber());
    }

    @Override
	public DescriptionWriter putList(String name, Iterable<?> objects) {
        return putList(name, objects, Descriptions.defaultDescriber());
    }

}
