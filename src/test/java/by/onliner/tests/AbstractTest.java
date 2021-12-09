package by.onliner.tests;

import by.onliner.driver.DriverFactory;
import by.onliner.driver.DriverManager;
import by.onliner.page.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static by.onliner.driver.DriverManager.getDriver;

public abstract class AbstractTest {

    public MainPage mainPage = new MainPage();

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));

    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}
