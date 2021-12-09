package by.onliner.page.pages;

import by.onliner.driver.DriverManager;
import by.onliner.page.AbstractPage;
import by.onliner.page.components.Menu;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static by.onliner.constants.OnlinerConstants.HOST;
import static by.onliner.util.ListUtil.getRandomWebElementFromList;

public class MainPage extends AbstractPage {

    private final int maxListSizeOnPage = 7;

    @FindBys({
            @FindBy(className = "catalog-offers__image")
    })
    private List<WebElement> catalogListItems;

    public MainPage() {
        super();
    }

    public MainPage openPage() {
        DriverManager.getDriver().navigate().to(HOST);
        return this;
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(getRandomWebElementFromList(catalogListItems, maxListSizeOnPage));
    }

    /***
     * Take menu for usage in tests
     * @return menu component
     */
    public Menu getMenu() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
        return new Menu();
    }

    /***
     * Click on the first catalog item
     */
    public void openCatalogFirstItem() {
        getRandomWebElementFromList(catalogListItems, maxListSizeOnPage).click();
    }
}
