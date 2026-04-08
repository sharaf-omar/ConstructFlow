package com.constructflow.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream inStream = ConfigLoader.class.getResourceAsStream("/db.properties");
            if (inStream == null) {
                inStream = ConfigLoader.class.getResourceAsStream("/dbExample.properties");
            }

            if (inStream == null) {
                throw new RuntimeException("db.properties or dbExample.properties not found in classpath; make sure src/main/resources is included.");
            }

            properties.load(inStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}