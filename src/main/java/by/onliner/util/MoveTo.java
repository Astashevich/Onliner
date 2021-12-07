package by.onliner.util;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/***
 * Wrapper class for actions moves by mouse to the defined element
 */
public class MoveTo {

    protected static Actions actions = new Actions(DriverManager.getDriver());

    public static void moveToElementAndClick(WebElement webElement) {
        actions.moveToElement(webElement).click(webElement).build().perform();
    }

    public static void clickElement(WebElement webElement) {
        actions.click();
    }
}
