package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterYmlLoader extends JsonParameterLoader implements YmlLoader<Step> {
    private static final Log log = getLog(JsonParameterYmlLoader.class);

	@Override
	public Step load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
		String jsonPath = loadMandatoryStr(yaml, JSONPATH);
		String source = loadOptionalStr(yaml, SOURCE);
		String value = loadOptionalStr(yaml, VALUE);
		String file = loadOptionalStr(yaml, FILE);
		ValueProcessor processor = loadOptionalValueProcessor(yaml, allIds);
		return buildJsonParameter(loadId(yaml, allIds), loadPrototype(yaml), loadContext(yaml), source, value, file, processor, jsonPath, log);
	}
}
