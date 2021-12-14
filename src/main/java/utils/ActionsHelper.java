package utils;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/***
 * Wrapper class for actions moves by mouse to the defined element
 */
public class ActionsHelper {

    private static final Actions actions = new Actions(DriverManager.getDriver());

    public static void moveToElementAndClick(WebElement webElement) {
        actions.moveToElement(webElement).click(webElement).build().perform();
    }
}
