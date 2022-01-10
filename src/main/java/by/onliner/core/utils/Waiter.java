package by.onliner.core.utils;

import by.onliner.core.driver.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class Waiter {

    private static final Duration TIMEOUT = Duration.ofSeconds(3);
    private static final Duration POLLING = Duration.ofMillis(100);

    private static final FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver());

    /***
     * Setup fluent wait driver
     * @return fluent wait object with certain timeout, polling and ignoring
     */
    private static FluentWait<WebDriver> fluentWaitSetup() {
        return fluentWait.withTimeout(TIMEOUT).pollingEvery(POLLING).ignoring(NoSuchElementException.class);
    }

    /***
     * Waits until the element to be clickable
     */
    public static void elementToBeClickable(WebElement element) {
        fluentWaitSetup()
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /***
     * Waits until the element is visible
     */
    public static void waitForVisibility(WebElement element) {
        fluentWaitSetup()
                .until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * Waits until the element is visible using custom timing
     */
    public static void waitForVisibility(WebElement element, int timeoutSec) {
        fluentWait
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(POLLING)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
