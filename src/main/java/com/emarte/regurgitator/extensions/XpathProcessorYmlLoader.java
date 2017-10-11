/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadMandatoryStr;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static com.emarte.regurgitator.extensions.YmlNamespaceLoader.loadNamespaces;

public class XpathProcessorYmlLoader implements YmlLoader<XpathProcessor> {
    private static final Log log = getLog(XpathProcessorYmlLoader.class);

    @Override
    public XpathProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xpath processor");
        return new XpathProcessor(loadMandatoryStr(yaml, XPATH), loadNamespaces(yaml.get(NAMESPACES)));
    }
}
