package by.onliner.util;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/***
 * Wrapper class for actions moves by mouse to the defined element
 */
public class ActionsHelper {

    public static void moveToElementAndClick(WebElement webElement) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(webElement).click(webElement).build().perform();
    }
}
