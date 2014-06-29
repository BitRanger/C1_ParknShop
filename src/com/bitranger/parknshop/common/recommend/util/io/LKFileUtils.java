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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.WillCloseWhenClosed;
import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;


public final class LKFileUtils {
    private static final Logger logger = LoggerFactory.getLogger(LKFileUtils.class);

    private LKFileUtils() {
    }

    /**
     * Query whether this filename represents a compressed file. It just looks at
     * the name to see if it ends in “.gz”.
     *
     * @param file The file to query.
     * @return {@code true} if the file name ends in “.gz”.
     * @deprecated Use {@link CompressionMode} or commons-compress facilities instead.
     */
    @Deprecated
    public static boolean isCompressed(File file) {
        return file.getName().endsWith(".gz");
    }

 
    public static Reader openInput(File file, Charset charset, CompressionMode compression) throws IOException {
        CompressionMode effComp = compression.getEffectiveCompressionMode(file.getName());
        InputStream istream = new FileInputStream(file);
            InputStream wrapped = null;// effComp.wrapInput(istream);
            return new InputStreamReader(wrapped, charset);
    }

    public static Reader openInput(File file, CompressionMode compression) throws IOException {
        return openInput(file, Charset.defaultCharset(), compression);
    }

    @SuppressWarnings("unused")
    public static Reader openInput(File file) throws IOException {
        return openInput(file, Charset.defaultCharset(), CompressionMode.AUTO);
    }



    /**
     * Auto-detect whether a stream needs decompression.  Currently detects GZIP compression (using
     * the GZIP magic in the header).
     *
     * @param stream The stream to read.
     * @return A stream that will read from {@code stream}, decompressing if needed.  It may not be
     *         the same object as {@code stream}, even if no decompression is needed, as the input
     *         stream may be wrapped in a buffered stream for lookahead.
     */
    public static InputStream transparentlyDecompress(@WillCloseWhenClosed InputStream stream) throws IOException {
        InputStream buffered;
        // get a markable stream
        if (stream.markSupported()) {
            buffered = stream;
        } else {
            logger.debug("stream {} does not support mark, wrapping", stream);
            buffered = new BufferedInputStream(stream);
        }

        // read the first 2 bytes for GZIP magic
        buffered.mark(2);
        int b1 = buffered.read();
        if (b1 < 0) {
            buffered.reset();
            return buffered;
        }
        int b2 = buffered.read();
        if (b2 < 0) {
            buffered.reset();
            return buffered;
        }
        buffered.reset();

        // they're in little-endian order
        int magic = b1 | (b2 << 8);

        logger.debug(String.format("found magic %x", magic));
        if (magic == GZIPInputStream.GZIP_MAGIC) {
            logger.debug("stream is gzip-compressed, decompressing");
            return new GZIPInputStream(buffered);
        }

        return buffered;
    }

}
