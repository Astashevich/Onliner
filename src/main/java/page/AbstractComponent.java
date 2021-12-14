package page;

import driver.DriverManager;
import elements.factory.ElementFactory;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {

    private WebDriver driver;

    public AbstractComponent() {
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
    }

    /***
     * Checks the element presence on a page.
     */
    protected abstract void waitForComponentOpened();
}
