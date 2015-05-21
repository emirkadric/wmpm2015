package com.workflow2015.common.helper;

import org.apache.camel.model.dataformat.XmlJsonDataFormat;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominik Heigl on 5/21/15.
 */
@Configuration
public class Xml2JsonConfiguration {

    private Map<String, String> xmlJsonOptions = new HashMap<>();

    public Xml2JsonConfiguration() {
        xmlJsonOptions.put(XmlJsonDataFormat.ENCODING, "UTF-8");
        xmlJsonOptions.put(XmlJsonDataFormat.FORCE_TOP_LEVEL_OBJECT, "true");
        xmlJsonOptions.put(XmlJsonDataFormat.TRIM_SPACES, "true");
        xmlJsonOptions.put(XmlJsonDataFormat.SKIP_NAMESPACES, "true");
        xmlJsonOptions.put(XmlJsonDataFormat.REMOVE_NAMESPACE_PREFIXES, "true");
    }

    public Map<String, String> getXmlJsonOptions() {
        return xmlJsonOptions;
    }
}
