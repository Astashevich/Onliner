package by.onliner.page.pages;

import by.onliner.elements.widget.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import by.onliner.page.AbstractPage;
import by.onliner.page.components.Menu;
import by.onliner.page.components.ShoppingCartPopup;
import by.onliner.utils.Waiter;

public class CatalogItemPage extends AbstractPage {

    private Menu menu;
    private ShoppingCartPopup shoppingCartPopup;

    @FindBy(linkText = "В корзину")
    private Button addToShoppingCartButton;

    @FindBy(linkText = "В корзине")
    private Button greenShoppingCartButton;

    public CatalogItemPage() {
        super();
        menu = new Menu();
        shoppingCartPopup = new ShoppingCartPopup();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(addToShoppingCartButton);
    }

    /***
     * Take menu for usage in tests
     * @return menu component
     */
    public Menu getMenu() {
        return menu;
    }

    /***
     * Click on the addToShoppingCart button.
     */
    @Step("Add item to the shopping cart")
    public void addToCart() {
        waitForPageOpened();
        addToShoppingCartButton.click();
        Waiter.waitForVisibility(greenShoppingCartButton);
        logger.info("Click 'В корзину' button");
        if (shoppingCartPopup.isShoppingCartPopupVisible()) {
            shoppingCartPopup.closeShoppingCartPopup();
        }
    }
}
