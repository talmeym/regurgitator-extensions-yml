/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;

import java.util.HashMap;
import java.util.Map;

import static com.emarte.regurgitator.core.Log.getLog;

class YmlNamespaceLoader extends NamespaceLoader {
    private static final Log log = getLog(YmlNamespaceLoader.class);

    static Map<String, String> loadNamespaces(Object object) {
        return object == null ? new HashMap<>() : object instanceof String ? loadNamespaces((String) object, log) : loadNamespaces((Map<Object, Object>) object);
    }

    private static Map<String, String> loadNamespaces(Map<Object, Object> values) {
        Map<String, String> namespaceMap = new HashMap<>();

        for(Object key: values.keySet()) {
            String prefix = (String) key;
            String uri = (String) values.get(prefix);
            namespaceMap.put(prefix, uri);
            log.debug("Loaded namespace '{}={}'", prefix, uri);
        }

        log.debug("Loaded {} namespaces", namespaceMap.size());
        return namespaceMap;
    }
}
