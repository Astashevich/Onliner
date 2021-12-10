package by.onliner.page;

import by.onliner.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractComponent {

    private WebDriver driver;

    public AbstractComponent() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    /***
     * Checks the element presence on a page.
     */
    protected abstract void waitForComponentOpened();
}
