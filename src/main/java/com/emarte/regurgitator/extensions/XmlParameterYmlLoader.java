package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static com.emarte.regurgitator.extensions.YmlNamespaceLoader.loadNamespaces;

public class XmlParameterYmlLoader extends XmlParameterLoader implements YmlLoader<Step> {
    private static final Log log = getLog(XmlParameter.class);

	@Override
	public Step load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
		String xpath = loadMandatoryStr(yaml, XPATH);
		String source = loadOptionalStr(yaml, SOURCE);
		String value = loadOptionalStr(yaml, VALUE);
		String file = loadOptionalStr(yaml, FILE);
		ValueProcessor processor = loadOptionalValueProcessor(yaml, allIds);
		return buildXmlParameter(loadId(yaml, allIds), loadPrototype(yaml), loadContext(yaml), source, value, file, processor, new XpathProcessor(xpath, loadNamespaces(yaml.getValues().get(NAMESPACES))), log);
	}
}
