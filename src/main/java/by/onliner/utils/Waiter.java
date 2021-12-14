package by.onliner.utils;

import by.onliner.driver.DriverManager;
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

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final Duration POLLING = Duration.ofMillis(500);

    private static final FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver());

    /***
     * Waits until the element to be clickable
     */
    public static void elementToBeClickable(WebElement element) {
        fluentWait
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /***
     * Waits until the element is visible
     */
    public static void waitForVisibility(WebElement element) {
        fluentWait
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * Waits until the element is visible using custom timing
     */
    public static void waitForVisibility(WebElement element, int timeoutSec, int pollingMils) {
        fluentWait
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(pollingMils))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
