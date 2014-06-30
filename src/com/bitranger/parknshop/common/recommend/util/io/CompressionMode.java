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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public enum CompressionMode {
    /**
     * No compression.
     */
    NONE,

    GZIP,

    /**
     * Automatically infer compression from file extension.
     */
    AUTO;

    private String compName;

    private CompressionMode() {
        this(null);
    }

    private CompressionMode(String name) {
        compName = name;
    }

    public String getCompressorName() {
        return compName;
    }

    /**
     * Get the effective compression mode.  For {@link #AUTO}, this auto-detects the appropriate
     * mode from the file name.
     *
     * @param filename The filename to compress.
     * @return The compression mode. Will never be {@link #AUTO}.
     */
    public CompressionMode getEffectiveCompressionMode(String filename) {
        return this;
    }


}
