package by.onliner.core.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Properties;

/***
 * Project environment data
 */
public class EnvironmentConfig {

    private static final String HOST = "host";
    private static final Properties properties;

    private final static String ENVIRONMENT_PROPERTIES_FILENAME = String.format("application-%s.properties", Environment.getEnvironment().getName());

    static {
        properties = PropertyReader.getInstance().readPropertyFile(ENVIRONMENT_PROPERTIES_FILENAME);
    }

    public static String getHost() {
        return properties.getProperty(HOST);
    }

    @Getter
    @AllArgsConstructor
    enum Environment {
        QA("qa"),
        DEV("dev"),
        LOCAL("local");

        String name;

        public static Environment getEnvironment() {
            String environment = System.getProperty("env");
            return Environment.readValue(environment);
        }

        public static Environment readValue(String text) {
            return Arrays.stream(Environment.values())
                    .filter(environment -> environment.getName().equalsIgnoreCase(text))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown environment value : " + text));
        }
    }
}
