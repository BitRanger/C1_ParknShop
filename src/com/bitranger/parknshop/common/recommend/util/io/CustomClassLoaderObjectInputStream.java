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

import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;



public class CustomClassLoaderObjectInputStream extends ObjectInputStream {
    private static final Logger logger = LoggerFactory.getLogger(CustomClassLoaderObjectInputStream.class);
    private final ClassLoader classLoader;

    public CustomClassLoaderObjectInputStream(InputStream in, ClassLoader loader) throws IOException {
        super(in);
        classLoader = loader;
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        if (classLoader == null) {
            return super.resolveClass(desc);
        } else {
            String name = desc.getName();
            logger.debug("resolving class {}", name);
            return ClassUtils.getClass(classLoader, name);
        }
    }
}
