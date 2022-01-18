package by.onliner.core.properties;

import by.onliner.core.driver.DriverFactory.BrowserType;

import java.util.Arrays;

/**
 * Get the type of browser to use.
 */
public class BrowserConfig {

    public static BrowserType getType() {
        String browser = System.getProperty("browser");
        return readValue(browser);
    }

    private static BrowserType readValue(String text) {
        return Arrays.stream(BrowserType.values())
                .filter(browser -> browser.name().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown browser value : " + text));
    }
}
