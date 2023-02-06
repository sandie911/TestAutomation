package com.hillel.util;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();

    public static final String BROWSER = prop.getProperty("browsers");
    public static final String BASE_URL = prop.getProperty("base.url");

    private ConfigProvider(){}

    private static Properties initProperties(){
        Properties properties= new Properties();

            try {
                properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
            } catch (IOException e) {
                throw new RuntimeException("Could not load property file");
            }

        return properties;
    }

}
