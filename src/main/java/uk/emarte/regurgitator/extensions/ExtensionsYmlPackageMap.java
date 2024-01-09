/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.AbstractYmlPackageMap;

import java.util.Arrays;
import java.util.List;

public class ExtensionsYmlPackageMap extends AbstractYmlPackageMap {
    private static final List<String> kinds = Arrays.asList("freemarker-builder", "freemarker-processor", "velocity-builder", "velocity-processor", "xml-parameter", "json-parameter", "contains-json-path", "contains-xpath", "xpath-processor", "json-path-processor", "json-print-processor", "xml-schema-validator");

    public ExtensionsYmlPackageMap() {
        addPackageMapping(kinds, "uk.emarte.regurgitator.extensions");
    }
}
