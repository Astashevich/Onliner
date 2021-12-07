package by.onliner.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;


public class DriverFactory {

    public enum BrowserType {FIREFOX, CHROME, EDGE, OPERA}

    /***
     * Chooses a webdriver of a defined type
     * @param browser
     */
    public static WebDriver getDriver(BrowserType browser) {
            WebDriver driver = null;
            switch (browser) {
                case FIREFOX:
                    driver = getGeckoDriver();
                    break;
                case CHROME:
                    driver = getChromeDriver();
                    break;
                case EDGE:
                    driver = getEdgeDriver();
                    break;
                case OPERA:
                    driver = getOperaDriver();
                    break;
            }
            return driver;
    }

    /**
     * Firefox webdriver settings
     * @return firefox webdriver
     */
    public static FirefoxDriver getGeckoDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-gpu", "--start-maximized");
        return new FirefoxDriver(firefoxOptions);
    }

    /***
     * Chrome webdriver settings
     * @return chrome webdriver
     */
    public static ChromeDriver getChromeDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-gpu", "--start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    /***
     * Edge webdriver settings
     * @return edge webdriver
     */
    public static EdgeDriver getEdgeDriver() {
        WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("disable-gpu", "--start-maximized");
        return new EdgeDriver(edgeOptions);
    }

    /***
     * Opera webdriver settings
     * @return opera webdriver
     */
    public static OperaDriver getOperaDriver() {
        WebDriverManager.getInstance(DriverManagerType.OPERA).setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments("disable-gpu", "--start-maximized");
        return new OperaDriver(operaOptions);
    }
}
