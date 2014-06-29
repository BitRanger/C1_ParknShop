/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2014 Regents of the University of Minnesota and contributors
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
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
