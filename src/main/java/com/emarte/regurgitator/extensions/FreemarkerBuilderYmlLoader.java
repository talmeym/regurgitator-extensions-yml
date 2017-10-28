/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadOptionalBool;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class FreemarkerBuilderYmlLoader extends FreemarkerBuilderLoader implements YmlLoader<ValueBuilder> {
    private static final Log log = getLog(FreemarkerBuilderYmlLoader.class);

    @Override
    public ValueBuilder load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        String source = loadOptionalStr(yaml, SOURCE);
        String value = loadOptionalStr(yaml, VALUE);
        String file = loadOptionalStr(yaml, FILE);
        boolean allContexts = loadOptionalBool(yaml, ALL_CONTEXTS);
        return buildFreemarkerValueBuilder(source, value, file, allContexts, log);
    }
}
