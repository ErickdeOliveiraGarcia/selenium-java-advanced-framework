package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;
    private final static String PROPERTY_FILE_PATH = "src/test/resources/config.properties";

    private ConfigLoader() {} //Private constructor to prevent instantiation

    // Método estático para carregar o arquivo uma única vez
    private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTY_FILE_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de propriedades: " + PROPERTY_FILE_PATH);
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar as configurações.");
        }
    }

    // Método principal para obter uma propriedade
    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        String property = properties.getProperty(key);
        if (property == null) {
            throw new RuntimeException("Chave '" + key + "' não encontrada no arquivo config.properties");
        }
        return property;
    }
}