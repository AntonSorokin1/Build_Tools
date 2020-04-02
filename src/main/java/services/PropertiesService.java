package services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {
    private static String propertiesPath = "properties/paths.properties";
    private static Properties properties = null;

    private PropertiesService() {}

    private static void getProperties() {
        properties = new Properties();
        try (InputStream inputStream = PropertiesService.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            properties.load(inputStream);
        }
        catch (NullPointerException | IOException e) {
            System.out.println("Can not read properties!");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) getProperties();
        return properties.getProperty(key);
    }
}
