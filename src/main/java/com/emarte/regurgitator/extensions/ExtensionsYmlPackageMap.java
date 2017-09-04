package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.AbstractYmlPackageMap;

import java.util.Arrays;
import java.util.List;

public class ExtensionsYmlPackageMap extends AbstractYmlPackageMap {
	private static final List<String> kinds = Arrays.asList("freemarker-builder", "freemarker-processor", "velocity-builder", "velocity-processor", "xml-parameter", "json-parameter", "contains-json-path", "contains-xpath", "xpath-processor", "json-path-processor", "xml-schema-validator");

	public ExtensionsYmlPackageMap() {
		addPackageMapping(kinds, "com.emarte.regurgitator.extensions");
	}
}
