package by.onliner.page.components;

import by.onliner.driver.DriverManager;
import by.onliner.elements.factory.ElementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {

    protected final Logger logger = LogManager.getLogger(this);

    protected WebDriver driver;

    public AbstractComponent() {
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
    }

    /***
     * Checks the element presence on a by.onliner.driver.
     */
    protected abstract void waitForComponentOpened();
}
