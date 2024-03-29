/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.*;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.CoreConfigConstants.VALUE;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.YmlConfigUtil.loadOptionalStr;

public class FreemarkerProcessorYmlLoader extends FreemarkerProcessorLoader implements YmlLoader<ValueProcessor> {
    private static final Log log = getLog(FreemarkerProcessorYmlLoader.class);

    @Override
    public ValueProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        String value = loadOptionalStr(yaml, VALUE);
        String file = loadOptionalStr(yaml, FILE);
        return buildFreemarkerValueProcessor(value, file, log);
    }
}
