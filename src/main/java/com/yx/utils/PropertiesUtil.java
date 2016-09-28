package com.yx.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * User: LiWenC
 * Date: 16-9-28
 */
public enum PropertiesUtil {

    INSTANCE;

    private Map<String, String> stringMap = new HashMap<String, String>();
    private Map<String, Integer> intMap = new HashMap<String, Integer>();
    private Map<String, Double> doubleMap = new HashMap<String, Double>();

    private PropertiesUtil() {
        try {
            Properties properties = new Properties();
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
            Enumeration names = properties.propertyNames();
            String name;
            String value;
            while (names.hasMoreElements()) {
                name = String.valueOf(names.nextElement());
                value = properties.getProperty(name);
                if (StringUtils.isNumeric(value)) {
                    intMap.put(name, Integer.valueOf(value));
                } else if (NumberUtils.isNumber(value)) {
                    doubleMap.put(name, NumberUtils.toDouble(value));
                } else {
                    stringMap.put(name, value);
                }
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("load file error!");
        }
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public Map<String, Integer> getIntMap() {
        return intMap;
    }

    public Map<String, Double> getDoubleMap() {
        return doubleMap;
    }
}
