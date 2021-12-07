package by.onliner.page;

import by.onliner.driver.DriverManager;
import by.onliner.dto.Menu;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import static by.onliner.constants.OnlinerConstants.*;


public class MainPage extends AbstractPage {

    @FindBy (xpath = "//div[@data-index= '1']")
    private WebElement catalogFirstItem;


    public MainPage() {
        super();
    }

    public MainPage openPage() {
        DriverManager.getDriver().navigate().to(HOST);
        return this;
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(catalogFirstItem);
    }

    /***
     * Click on the first catalog item
     */
    public void openCatalogFirstItem() {
        catalogFirstItem.click();
    }
}
