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


import java.io.Serializable;


@Deprecated
public interface Index extends Serializable {
    /**
     * Get the index of an id.  If the id is not in the index, returns a negative number.
     *
     * @param id The id to query.
     * @return The id's index or a negative value if the id does not exist.
     */
    int getIndex(long id);

    /**
     * Get the id for an index.
     *
     * @param idx The index of the ID to retrieve.
     * @return The ID for the given {@var idx}.
     */
    long getId(int idx);

    /**
     * Get the number of IDs in the index.
     *
     * @return The number of indexed ids.
     */
    int getObjectCount();

}
