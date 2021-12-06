package by.onliner.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    /***
     * The field type bound to the stream.
     * Each stream has its own field.
     */
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    /***
     * Returns the value in a copy of the current thread by this thread-local variable
     * @return webdriver of the current thread
     */
    public static WebDriver getDriver() {return threadDriver.get();}

    /***
     * Sets the value in a copy of the current thread by this thread-local variable
     * @param driver
     * @return webdriver of the current thread
     */
    public static void setDriver(WebDriver driver) {threadDriver.set(driver);}

    /***
     *  Remove the value in a copy of the current thread by this thread-local variable
     * @param driver
     */
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }


}
