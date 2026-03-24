package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig {
    private final Properties properties;

    private EnvConfig(Properties properties) {
        this.properties = properties;
    }

    public static EnvConfig load(String path) {
        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream(path)) {
            props.load(input);
        } catch (IOException e) {
            System.out.println("Could not read .env file: " + e.getMessage());
        }

        return new EnvConfig(props);
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
