/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.Yaml;
import uk.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;

public class JsonPrintProcessorYmlLoader implements YmlLoader<JsonPrintProcessor> {
    private static final Log log = getLog(JsonPrintProcessorYmlLoader.class);

    @Override
    public JsonPrintProcessor load(Yaml yaml, Set<Object> allIds) {
        log.debug("Loaded json print processor");
        return new JsonPrintProcessor();
    }
}
