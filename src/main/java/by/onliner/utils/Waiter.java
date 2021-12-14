package by.onliner.utils;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class Waiter {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TIMEOUT);
    private static FluentWait fluentWait = new FluentWait(DriverManager.getDriver());

    public static void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * Waits until the element is displayed using custom timing
     */
    public static void waitForVisibility(WebElement element, int timeoutSec, int pollingMils) {
        fluentWait
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(pollingMils))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
