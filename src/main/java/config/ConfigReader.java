package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/resources//configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties. not found at " + propertyFilePath);
        }
    }
    // Provides Global point of access
    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }
    public String getBaseUrl(String url) {
        String baseUrl = properties.getProperty(url);
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.configuration.properties. file.");
    }

    public int getBasePort() {
        String port = properties.getProperty("port");
        int basePort = Integer.parseInt(port);
        if (port != null) return basePort;
        else throw new RuntimeException("port not specified in the Configuration.configuration.properties. file.");

    }
}
