package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.Yaml;
import com.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.YmlConfigUtil.loadMandatoryStr;

public class XmlSchemaValidatorYmlLoader implements YmlLoader<XmlSchemaValidator> {
	private static final Log log = getLog(XmlSchemaValidatorYmlLoader.class);

	@Override
	public XmlSchemaValidator load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded xml schema validator");
		return new XmlSchemaValidator(loadMandatoryStr(yaml, FILE));
	}
}
