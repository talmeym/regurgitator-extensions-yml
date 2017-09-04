package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonPathProcessorYmlLoader implements YmlLoader<JsonPathProcessor> {
	private static final Log log = getLog(JsonPathProcessor.class);

	@Override
	public JsonPathProcessor load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded json path processor");
		return new JsonPathProcessor(YmlConfigUtil.loadMandatoryStr(yaml, JSONPATH));
	}
}
