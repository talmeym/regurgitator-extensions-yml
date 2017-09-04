package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.Yaml;
import com.emarte.regurgitator.core.YmlLoader;

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
		return new XpathProcessor(loadMandatoryStr(yaml, XPATH), loadNamespaces(yaml.getValues().get(NAMESPACES)));
	}
}
