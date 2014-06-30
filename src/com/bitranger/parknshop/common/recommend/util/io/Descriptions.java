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
