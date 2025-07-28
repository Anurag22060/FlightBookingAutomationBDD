package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static String get(String key) {
        if (prop == null) {
            try (FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties")) {
                prop = new Properties();
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load config.properties file.");
            }
        }
        return prop.getProperty(key);
    }
}
