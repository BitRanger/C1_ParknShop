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



public interface DescriptionWriter {
    /**
     * Put a field into the description.
     */
    DescriptionWriter putField(String name, String value);

    /**
     * Put an integer field.
     */
    DescriptionWriter putField(String name, long value);

    /**
     * Put a floating-point field.
     */
    DescriptionWriter putField(String name, double value);

    /**
     * Put a byte array field.
     * @param name The field name.
     * @param value The field value.
     * @see #putField(String, String)
     */
    DescriptionWriter putField(String name, byte[] value);

    /**
     * Put an object field into the description.
     * @param name The field name. It cannot begin with an underscore.
     * @param value The field value.  It is described with {@link org.grouplens.lenskit.util.io.Descriptions#defaultDescriber()}}.
     */
    DescriptionWriter putField(String name, Object value);

    /**
     * Put a field with a list of values, using the default describer.
     * @param name The field name.
     * @param objects The list of objects.
     * @return The description writer (for chaining).
     */
    DescriptionWriter putList(String name, Iterable<?> objects);

    /**
     * Put a field with a list of values.
     * @param name The field name.
     * @param objects The list of objects.
     * @param describer A describer for the objects.
     * @param <T> The type of objects in the list.
     * @return The description writer (for chaining).
     */
    <T> DescriptionWriter putList(String name, Iterable<T> objects,
                                  Describer<? super T> describer);

    /**
     * Put an object field into the description.
     * @param name The field name. It cannot begin with an underscore.
     * @param value The field value.  If it implements {@link org.grouplens.lenskit.util.io.Describable}, then it is asked to write
     *              its description; otherwise, some default behavior is used.
     * @param describer A describer to describe the value.
     */
    <T> DescriptionWriter putField(String name, T value, Describer<? super T> describer);
}
