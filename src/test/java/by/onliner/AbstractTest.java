package by.onliner;

import by.onliner.core.driver.DriverFactory;
import by.onliner.core.driver.DriverManager;
import by.onliner.core.listener.TestListener;
import by.onliner.core.configer.BrowserConfig;
import by.onliner.core.utils.FileUtil;
import by.onliner.page.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import static by.onliner.constants.OnlinerConstants.LOG_PATH;
import static by.onliner.constants.OnlinerConstants.SAVE_VIDEO_PATH;
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

    /***
     * Delete files after all tests.
     */
    @AfterSuite(alwaysRun = true)
    public void onSuitFinish() {
        try {
            FileUtils.deleteDirectory(new File(SAVE_VIDEO_PATH));
            FileUtil.clearTextFile(LOG_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}