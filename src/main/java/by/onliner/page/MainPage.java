package by.onliner.page;

import by.onliner.driver.DriverManager;
import by.onliner.elements.widget.Link;
import by.onliner.page.components.Footer;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import by.onliner.page.components.Menu;
import by.onliner.utils.Waiter;
import java.util.List;
import java.util.Random;

import static by.onliner.constants.OnlinerConstants.HOST;

public class MainPage extends AbstractPage {

    private static final int MAX_LIST_SIZE_ON_PAGE = 7;
    private final Menu menu;
    private final Footer footer;

    @FindBy(className = "catalog-offers__image")
    private List<Link> catalogItems;

    public MainPage() {
        super();
        menu = new Menu();
        footer = new Footer();
    }

    @Step("Open page: Onliner.by")
    public MainPage openPage() {
        DriverManager.getDriver().navigate().to(HOST);
        waitForPageOpened();
        logger.info(String.format("Home page was opened: %s", HOST));
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
        return menu;
    }

    /***
     * Take footer for usage in tests
     * @return footer component
     */
    public Footer getFooter() {
        return footer;
    }

    /***
     * Click on the first catalog item
     */
    @Step("Open catalog random item")
    public void openCatalogRandomItem() {
        catalogItems.get(new Random().nextInt(MAX_LIST_SIZE_ON_PAGE)).click();
        logger.info("Open 'Random catalog item' from main page");
    }
}
