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
package com.bitranger.parknshop.common.recommend.util.io;

import java.io.Serializable;


public final class Descriptions {



    private Descriptions() {}

    /**
     * default describer.
     */
    public static Describer<Object> defaultDescriber() {
        return DefaultDescriber.INSTANCE;
    }

    private static enum DefaultDescriber implements Describer<Object> {
        INSTANCE;

        @Override
        public void describe(Object obj, DescriptionWriter description) {
            if (obj == null) {
                description.putField("type", "null");
                return;
            }
            description.putField("type", obj.getClass().getName());
            if (obj instanceof String) {
                description.putField("string", (String) obj);
            } else if (obj instanceof Number) {
                description.putField("number", obj.toString());
            } if (obj instanceof Describable) {
                ((Describable) obj).describeTo(description);
            } else if (obj instanceof Serializable) {
                description.putField("_uuid", obj.toString());
            }
        }
    }
}
