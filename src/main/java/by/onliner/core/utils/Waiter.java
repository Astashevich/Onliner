package by.onliner.core.utils;

import by.onliner.core.driver.DriverManager;
import org.awaitility.Awaitility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class Waiter {

    private static final Duration TIMEOUT = Duration.ofSeconds(3);
    private static final Duration POLLING = Duration.ofMillis(100);
    private static final long ONE_THOUSAND = 1000L;

    private static final FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver());

    /***
     * Setup fluent wait driver
     * @return fluent wait object with certain timeout, polling and ignoring
     */
    private static FluentWait<WebDriver> fluentWaitSetup() {
        return fluentWait.withTimeout(TIMEOUT).pollingEvery(POLLING)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
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

    /***
     * Sleep driver using custom timing
     */
    public static void sleep(int timeoutSec) {
        try {
            Thread.sleep(timeoutSec * ONE_THOUSAND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeChanged(WebElement element) {
        String elementText = element.getText();
        Awaitility.await().pollInterval(POLLING).atMost(TIMEOUT)
                .untilAsserted(() -> Assert.assertNotEquals(elementText, element.getText()));
    }
}
