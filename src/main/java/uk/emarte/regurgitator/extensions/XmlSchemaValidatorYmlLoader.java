/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.Yaml;
import uk.emarte.regurgitator.core.YmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.YmlConfigUtil.loadMandatoryStr;

public class XmlSchemaValidatorYmlLoader implements YmlLoader<XmlSchemaValidator> {
    private static final Log log = getLog(XmlSchemaValidatorYmlLoader.class);

    @Override
    public XmlSchemaValidator load(Yaml yaml, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xml schema validator");
        return new XmlSchemaValidator(loadMandatoryStr(yaml, FILE));
    }
}
