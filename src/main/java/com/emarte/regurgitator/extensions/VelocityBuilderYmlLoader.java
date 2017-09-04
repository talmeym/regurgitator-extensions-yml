package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadOptionalBoolean;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class VelocityBuilderYmlLoader extends VelocityBuilderLoader implements YmlLoader<ValueBuilder> {
	private static final Log log = getLog(VelocityBuilderYmlLoader.class);

	@Override
	public ValueBuilder load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
		String source = loadOptionalStr(yaml, SOURCE);
		String value = loadOptionalStr(yaml, VALUE);
		String file = loadOptionalStr(yaml, FILE);
		boolean allContexts = loadOptionalBoolean(yaml, ALL_CONTEXTS);
		return buildVelocityValueBuilder(source, value, file, allContexts, log);
	}
}
