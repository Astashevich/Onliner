package by.onliner.core.configer;

import by.onliner.core.utils.PropertyReader;
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

    static {
        String environmentPropertiesFileName = String.format("application-%s.properties", Environment.getEnvironment().getName());
        properties = PropertyReader.getInstance().readPropertyFile(environmentPropertiesFileName);
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

        private static Environment readValue(String text) {
            return Arrays.stream(Environment.values())
                    .filter(environment -> environment.getName().equalsIgnoreCase(text))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown environment value : " + text));
        }
    }
}
