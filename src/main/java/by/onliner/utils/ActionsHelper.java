package by.onliner.utils;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


/***
 * Wrapper class for actions moves by mouse to the defined element
 */
public class ActionsHelper {

    private static final Actions actions = new Actions(DriverManager.getDriver());

    public static void moveToElementAndClick(WebElement webElement) {
        actions.moveToElement(webElement).pause(Duration.ofMillis(200)).click(webElement).build().perform();
    }
}
