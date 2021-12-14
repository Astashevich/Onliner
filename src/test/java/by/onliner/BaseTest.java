package by.onliner;

import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.pages.CatalogItemPage;
import page.pages.MainPage;
import page.pages.ShoppingCartPage;
import static driver.DriverManager.getDriver;

public abstract class BaseTest {

    protected MainPage mainPage;
    protected CatalogItemPage catalogPageItem;
    protected ShoppingCartPage shoppingCartPage;

    /***
     * Set and open the local thread browser type with page initialisation.
     */
    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
        mainPage = new MainPage();
        catalogPageItem = new CatalogItemPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}