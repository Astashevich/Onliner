package by.onliner.page.pages;

import by.onliner.driver.DriverManager;
import by.onliner.page.AbstractPage;
import by.onliner.page.components.Menu;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;
import static by.onliner.constants.OnlinerConstants.HOST;

public class MainPage extends AbstractPage {

    private static final int MAX_LIST_SIZE_ON_PAGE = 7;

    @FindBy(className = "catalog-offers__image")
    private List<WebElement> catalogItems;

    public MainPage() {
        super();
    }

    public MainPage openPage() {
        DriverManager.getDriver().navigate().to(HOST);
        waitForPageOpened();
        return this;
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(catalogItems.get(new Random().nextInt(MAX_LIST_SIZE_ON_PAGE)));
    }

    /***
     * Take menu for usage in tests
     * @return menu component
     */
    public Menu getMenu() {
        return new Menu();
    }

    /***
     * Click on the first catalog item
     */
    public void openCatalogRandomItem() {
        catalogItems.get( new Random().nextInt(MAX_LIST_SIZE_ON_PAGE)).click();
    }
}
