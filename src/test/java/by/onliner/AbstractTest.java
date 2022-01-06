package by.onliner;

import by.onliner.core.driver.DriverFactory;
import by.onliner.core.driver.DriverManager;
import by.onliner.page.CatalogItemPage;
import by.onliner.page.MainPage;
import by.onliner.page.ShoppingCartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static by.onliner.core.driver.DriverManager.getDriver;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Listeners(TestListener.class)
public abstract class AbstractTest {

    protected MainPage mainPage;
    protected CatalogItemPage catalogPageItem;
    protected ShoppingCartPage shoppingCartPage;

    /***
     * Set and open the local thread browser type with by.onliner.core.driver initialisation.
     * And write allure environment for reporting.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
        mainPage = new MainPage();
        catalogPageItem = new CatalogItemPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    /***
     * Closes the local thread by.onliner.core.driver.
     */
    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        DriverManager.quitDriver(getDriver());
    }
}