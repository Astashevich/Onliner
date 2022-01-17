package by.onliner.core.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Class for getting variables from property file
 */
public final class PropertyReader {

    private static final Logger logger = LogManager.getLogger();
    private static PropertyReader propertyReader;
    private final Properties properties = new Properties();
    private HashMap<String, Properties> propertiesHashMap = new HashMap<>();

    private PropertyReader() {
    }

    /***
     * Reads property file
     * @param fileName property file
     */
    private void readPropertyFile(String fileName) {
        if (!propertiesHashMap.containsKey(fileName)) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                logger.debug("Cannot read the file");
                throw new UncheckedIOException(e);
            }
            propertiesHashMap.put(fileName, properties);
        }
    }

    public static synchronized PropertyReader getPropertyReader() {
        if (propertyReader == null) {
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

    /**
     * Method allows to get data from property file
     *
     * @param propKey is the key of the data in the property file
     * @return the data
     */
    public String getProperty(String fileName, String propKey) {
        readPropertyFile(fileName);
        return propertiesHashMap.get(fileName).getProperty(propKey);
    }
}
