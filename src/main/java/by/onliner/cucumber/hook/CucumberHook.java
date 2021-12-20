package by.onliner.cucumber.hook;

import by.onliner.driver.DriverFactory;
import by.onliner.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static by.onliner.driver.DriverFactory.getDriver;
import static by.onliner.driver.DriverManager.getDriver;

/***
 * Hook is used to initiate and cancel work of the current thread webdriver
 */
public class CucumberHook {

    @Before
    public void initBrowser() {
        DriverManager.setDriver(getDriver(DriverFactory.BrowserType.CHROME));
    }

    @After
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}
