package hu.elte.selenium.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads test configuration values from test.properties.
 */
public class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException("test.properties file was not found in src/test/resources");
            }

            PROPERTIES.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not read test.properties file", exception);
        }
    }

    private ConfigReader() {
        // Utility class, instances are not needed.
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }
}