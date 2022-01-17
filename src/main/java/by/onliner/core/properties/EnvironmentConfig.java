package by.onliner.core.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/***
 * Project environment data
 */
public class EnvironmentConfig {

    private static final String HOST = "host";
    private static final String LOG_PATH = "logPath";
    private static final String SAVE_VIDEO_PATH = "saveVideoPath";

    private final static String ENVIRONMENT_PROPERTIES = "application-%s.properties";
    private final static String ENVIRONMENT_DEFAULT_PROPERTY = "application-local.properties";

    public static String getHost() {
        return PropertyReader.getPropertyReader()
                .getProperty(String.format(ENVIRONMENT_PROPERTIES, Environment.setEnvironment().getName()), HOST);
    }

    public static String getLogPath() {
        return PropertyReader.getPropertyReader()
                .getProperty(String.format(ENVIRONMENT_PROPERTIES, Environment.setEnvironment().getName()), LOG_PATH);
    }

    public static String getSaveVideoPath() {
        return PropertyReader.getPropertyReader()
                .getProperty(String.format(ENVIRONMENT_PROPERTIES, Environment.setEnvironment().getName()), SAVE_VIDEO_PATH);
    }

    @Getter
    @AllArgsConstructor
    enum Environment {
        QA("qa"),
        DEV("dev"),
        LOCAL("local");

        String name;

        public static Environment setEnvironment() {
            String defaultEnvironment = System.getProperty("env");
            String environment = defaultEnvironment == null ? PropertyReader.getPropertyReader()
                            .getProperty(ENVIRONMENT_DEFAULT_PROPERTY, "environment") : defaultEnvironment;
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
