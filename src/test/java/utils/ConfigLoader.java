package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;
    private final static String PROPERTY_FILE_PATH = "src/test/resources/config.properties";

    private ConfigLoader() {} //Private constructor to prevent instantiation

        //Static method to load the properties file only once
        private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTY_FILE_PATH)) {
            properties.load(inputStream);

        } catch (IOException e) {
            System.err.println("Error loading properties file: " + PROPERTY_FILE_PATH);
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration.");
        }
    }

    //Main method to get a property value by key
    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        String property = properties.getProperty(key);
        if (property == null) {
            throw new RuntimeException("Key '" + key + "' not found in config.properties");
        }
        return property;
    }
}