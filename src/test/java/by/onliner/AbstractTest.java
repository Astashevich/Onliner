package by.onliner;

import by.onliner.core.driver.DriverFactory;
import by.onliner.core.driver.DriverManager;
import by.onliner.core.listener.TestListener;
import by.onliner.core.configer.BrowserConfig;
import by.onliner.page.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static by.onliner.core.driver.DriverManager.getDriver;

@Listeners(TestListener.class)
public abstract class AbstractTest {

    protected MainPage mainPage;
    protected CatalogItemPage catalogPageItem;
    protected ShoppingCartPage shoppingCartPage;
    protected AboutCompanyPage aboutCompanyPage;
    protected LogInPage logInPage;

    /***
     * Set and open the local thread browser type with by.onliner.core.driver initialisation.
     * And write allure environment for reporting.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType()));
        mainPage = new MainPage();
        catalogPageItem = new CatalogItemPage();
        shoppingCartPage = new ShoppingCartPage();
        aboutCompanyPage = new AboutCompanyPage();
        logInPage = new LogInPage();
    }

    /***
     * Closes the local thread by.onliner.core.driver.
     */
    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}