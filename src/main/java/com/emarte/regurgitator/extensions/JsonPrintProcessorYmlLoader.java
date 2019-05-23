/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.Yaml;
import com.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;

public class JsonPrintProcessorYmlLoader implements YmlLoader<JsonPrintProcessor> {
    private static final Log log = getLog(JsonPrintProcessorYmlLoader.class);

    @Override
    public JsonPrintProcessor load(Yaml yaml, Set<Object> allIds) {
        log.debug("Loaded json print processor");
        return new JsonPrintProcessor();
    }
}
