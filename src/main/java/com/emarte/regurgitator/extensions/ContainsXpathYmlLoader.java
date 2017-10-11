/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.Yaml;
import com.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.YmlNamespaceLoader.loadNamespaces;

public class ContainsXpathYmlLoader implements YmlLoader<ContainsXpath> {
    private static final Log log = getLog(ContainsXpathYmlLoader.class);

    @Override
    public ContainsXpath load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded contains xpath");
        return new ContainsXpath(loadNamespaces(yaml.get(NAMESPACES)));
    }
}
