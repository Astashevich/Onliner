package by.onliner.util;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class Waiter {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TIMEOUT);

    public static void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
