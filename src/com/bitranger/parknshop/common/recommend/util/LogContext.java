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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;


public class LogContext {
    private final Map memory = new HashMap<>();

    public void put(String key, String value) {
        MDC.put(key, value);
    }

   
}
