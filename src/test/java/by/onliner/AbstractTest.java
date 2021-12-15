package by.onliner;

import by.onliner.driver.DriverFactory;
import by.onliner.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import by.onliner.page.pages.CatalogItemPage;
import by.onliner.page.pages.MainPage;
import by.onliner.page.pages.ShoppingCartPage;
import static by.onliner.driver.DriverManager.getDriver;

public abstract class AbstractTest {

    protected MainPage mainPage;
    protected CatalogItemPage catalogPageItem;
    protected ShoppingCartPage shoppingCartPage;

    /***
     * Set and open the local thread browser type with by.onliner.driver initialisation.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
        mainPage = new MainPage();
        catalogPageItem = new CatalogItemPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    /***
     * Closes the local thread by.onliner.driver.
     */
    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}