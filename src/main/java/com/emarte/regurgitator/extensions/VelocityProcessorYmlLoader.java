/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.CoreConfigConstants.VALUE;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadOptionalStr;

public class VelocityProcessorYmlLoader extends VelocityProcessorLoader implements YmlLoader<ValueProcessor> {
    private static final Log log = getLog(VelocityProcessorYmlLoader.class);

    @Override
    public ValueProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        String value = loadOptionalStr(yaml, VALUE);
        String file = loadOptionalStr(yaml, FILE);
        return buildVelocityValueProcessor(value, file, log);
    }
}
