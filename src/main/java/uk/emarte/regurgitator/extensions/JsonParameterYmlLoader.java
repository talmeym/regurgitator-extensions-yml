/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.*;

import java.util.List;
import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.YmlConfigUtil.*;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterYmlLoader extends JsonParameterLoader implements YmlLoader<Step> {
    private static final Log log = getLog(JsonParameterYmlLoader.class);

    @Override
    public Step load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        String jsonPath = loadMandatoryStr(yaml, JSONPATH);
        String source = loadOptionalStr(yaml, SOURCE);
        String value = loadOptionalStr(yaml, VALUE);
        String file = loadOptionalStr(yaml, FILE);
        List<ValueProcessor> processors = loadOptionalValueProcessors(yaml, allIds);
        return buildJsonParameter(loadId(yaml, allIds), loadPrototype(yaml), loadContext(yaml), source, value, file, processors, jsonPath, loadOptionalBool(yaml, OPTIONAL), log);
    }
}
