/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.*;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.YmlConfigUtil.loadOptionalBool;
import static uk.emarte.regurgitator.core.YmlConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class VelocityBuilderYmlLoader extends VelocityBuilderLoader implements YmlLoader<ValueBuilder> {
    private static final Log log = getLog(VelocityBuilderYmlLoader.class);

    @Override
    public ValueBuilder load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        String source = loadOptionalStr(yaml, SOURCE);
        String value = loadOptionalStr(yaml, VALUE);
        String file = loadOptionalStr(yaml, FILE);
        boolean allContexts = loadOptionalBool(yaml, ALL_CONTEXTS);
        return buildVelocityValueBuilder(source, value, file, allContexts, log);
    }
}
