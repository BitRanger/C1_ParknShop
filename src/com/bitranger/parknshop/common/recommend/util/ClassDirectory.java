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

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * 
 * @author BowenCai
 *
 */
public class ClassDirectory {

    public static ClassDirectory forCurrentClassLoader() {
        return forClassLoader(Thread.currentThread().getContextClassLoader());
    }


    public static ClassDirectory forClassLoader(ClassLoader loader) {
        ImmutableSetMultimap.Builder<String,String> mapping = ImmutableSetMultimap.builder();
        try {
           Enumeration<URL> urls = loader.getResources("WEB-INF/classes.lst");
//            while (urls.hasMoreElements()) {
//                URL url = urls.nextElement();
//                Double closer = Closer.create();
//                try {
//                    InputStream stream = closer.register(url.openStream());
//                    Reader rdr = closer.register(new InputStreamReader(stream, "UTF-8"));
//                    BufferedReader buf = closer.register(new BufferedReader(rdr));
//                    String line = buf.readLine();
//                    while (line != null) {
//                        int idx = line.lastIndexOf('.');
//                        if (idx >= 0) {
//                            String name = line.substring(idx + 1);
//                            String pkg = line.substring(0, idx);
//                            mapping.put(name, pkg);
//                        }
//                        line = buf.readLine();
//                    }
//                } catch (Throwable th) {
//                    throw closer.rethrow(th);
//                } finally {
//                    closer.close();
//                }
//            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading class lists", e);
        }

        return new ClassDirectory(mapping.build());
    }

    private final SetMultimap<String, String> directory;

    private ClassDirectory(SetMultimap<String,String> map) {
        directory = map;
    }

    /**
     * Get the packages that contain a class with the specified name.
     * @param name The name to look for.
     * @return The set of packages (empty if the name is unknown).
     */
    public Set<String> getPackages(String name) {
        return directory.get(name);
    }
}
