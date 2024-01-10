/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.Yaml;
import uk.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.YmlConfigUtil.loadMandatoryStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonPathProcessorYmlLoader implements YmlLoader<JsonPathProcessor> {
    private static final Log log = getLog(JsonPathProcessor.class);

    @Override
    public JsonPathProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded json path processor");
        return new JsonPathProcessor(loadMandatoryStr(yaml, JSONPATH));
    }
}
