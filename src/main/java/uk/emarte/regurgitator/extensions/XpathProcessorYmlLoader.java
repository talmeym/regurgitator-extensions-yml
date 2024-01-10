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
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static uk.emarte.regurgitator.extensions.YmlNamespaceLoader.loadNamespaces;

public class XpathProcessorYmlLoader implements YmlLoader<XpathProcessor> {
    private static final Log log = getLog(XpathProcessorYmlLoader.class);

    @Override
    public XpathProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xpath processor");
        return new XpathProcessor(loadMandatoryStr(yaml, XPATH), loadNamespaces(yaml.get(NAMESPACES)));
    }
}
