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


import javax.annotation.Nonnull;
import javax.annotation.WillCloseWhenClosed;
import java.io.*;
import java.util.regex.Pattern;


public class DelimitedTextCursor {
    private BufferedReader input;
    private Pattern delimiter;
    private int lineNumber = 0;

    /**
     * Construct a cursor reading text from a scanner with a regex delimiter.
     *
     * @param in    The input scanner.
     * @param delim The delimiter.
     */
    public DelimitedTextCursor(@WillCloseWhenClosed @Nonnull BufferedReader in,
                               @Nonnull Pattern delim) {
        input = in;
        delimiter = delim;
    }

    /**
     * Construct a cursor reading text from a scanner with a fixed delimiter.
     *
     * @param in    The scanner to read from.
     * @param delim The delimiter string.
     */
    public DelimitedTextCursor(@WillCloseWhenClosed @Nonnull BufferedReader in,
                               @Nonnull String delim) {
        this(in, Pattern.compile(Pattern.quote(delim)));
    }

    /**
     * Construct a delimited text cursor from a file.
     *
     * @param file  The name of the file to read.
     * @param delim The delimiter.
     * @throws FileNotFoundException if {@var file} is not found.
     */
    public DelimitedTextCursor(File file, @Nonnull String delim) throws FileNotFoundException {
        // REVIEW This doesn't handle an error constructing the BufferedReader
        this(new BufferedReader(new FileReader(file)), delim);
    }

    public String[] poll() {
        String line;
        try {
            line = input.readLine();
        } catch (IOException e) {
            throw new RuntimeException("error reading line", e);
        }
        if (line == null) {
            return null;
        } else {
            lineNumber++;
            return delimiter.split(line);
        }
    }

    /**
     * Return the number of the line returned by the last call to {@link #next()}.
     *
     * @return The number of the last line retrieved.
     */
    public int getLineNumber() {
        return lineNumber;
    }

    public void close() {
        try {
            input.close();
        } catch (IOException ex) {
        	throw new RuntimeException(ex);
        }
    }
}
