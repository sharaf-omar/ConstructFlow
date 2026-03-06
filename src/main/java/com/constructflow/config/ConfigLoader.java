package com.constructflow.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input = ConfigLoader.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}