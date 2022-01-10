package by.onliner.page;


import by.onliner.core.driver.DriverManager;
import by.onliner.core.elements.factory.ElementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected final Logger logger = LogManager.getLogger(this);

    protected WebDriver driver;

    public AbstractPage() {
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
    }

    /***
     * Checks the element presence on a by.onliner.core.driver.
     */
    protected abstract void waitForPageOpened();
}
