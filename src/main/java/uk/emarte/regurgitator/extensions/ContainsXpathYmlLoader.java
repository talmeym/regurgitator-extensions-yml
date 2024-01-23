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
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.YmlNamespaceLoader.loadNamespaces;

public class ContainsXpathYmlLoader implements YmlLoader<ContainsXpathBehaviour> {
    private static final Log log = getLog(ContainsXpathYmlLoader.class);

    @Override
    public ContainsXpathBehaviour load(Yaml yaml, Set<Object> allIds) {
        log.debug("Loaded contains xpath");
        return new ContainsXpathBehaviour(loadNamespaces(yaml.get(NAMESPACES)));
    }
}
