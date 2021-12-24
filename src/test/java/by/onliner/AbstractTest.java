package by.onliner;

import by.onliner.driver.DriverFactory;
import by.onliner.driver.DriverManager;
import by.onliner.page.*;
import by.onliner.test_dev.listener.TestListener;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import static by.onliner.driver.DriverManager.getDriver;

@Listeners(TestListener.class)
public abstract class AbstractTest {

    protected MainPage mainPage;
    protected CatalogItemPage catalogPageItem;
    protected ShoppingCartPage shoppingCartPage;
    protected AboutCompanyPage aboutCompanyPage;
    protected LogInPage logInPage;
    protected Faker faker;

    /***
     * Set and open the local thread browser type with by.onliner.driver initialisation.
     * And write allure environment for reporting.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
        mainPage = new MainPage();
        catalogPageItem = new CatalogItemPage();
        shoppingCartPage = new ShoppingCartPage();
        aboutCompanyPage = new AboutCompanyPage();
        logInPage = new LogInPage();
        faker = new Faker();
    }

    /***
     * Closes the local thread by.onliner.driver.
     */
    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}