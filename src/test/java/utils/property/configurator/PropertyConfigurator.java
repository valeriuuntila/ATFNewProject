//package utils.property.configurator;
//
//import org.apache.logging.log4j.LogManager;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class PropertyConfigurator {
//
//    public static String getProperty(String key)   {
//        Properties prop = readPropertiesFile();
//        String value = prop.getProperty(key);
//
//        return (value != null) ? value : handleMissingProperty(key);
//    }
//
//    private static Properties readPropertiesFile() {
//        Properties prop = new Properties();
//        try (FileInputStream fis = new FileInputStream("src/test/resources/properties/test.properties")) {
//            prop.load(fis);
//        } catch (IOException e) {
//            LogManager.getLogger().error("Unable to read properties file from path: src/test/resources/properties/", e);
//        }
//        return prop;
//    }
//
//    private static String handleMissingProperty(String key) throws PropertyNotFoundException {
//        LogManager.getLogger().error("Property with key '" + key + "' not found.");
//        throw new PropertyNotFoundException("Property with key '" + key + "' not found.");
//    }
//}
package utils.property.configurator;

import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfigurator {

    public static String getProperty(String key) {
        Properties prop = readPropertiesFile();
        String value = prop.getProperty(key);

        if (value != null) {
            return value;
        } else {
            return handleMissingProperty(key);
        }
    }

    private static Properties readPropertiesFile() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/properties/test.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            LogManager.getLogger().error("Unable to read properties file from path: src/test/resources/properties/", e);
        }
        return prop;
    }

    private static String handleMissingProperty(String key) {
        LogManager.getLogger().error("Property with key '" + key + "' not found.");
        throw new IllegalArgumentException("Property with key '" + key + "' not found.");
    }
}
