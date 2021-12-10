package by.onliner.page.pages;

import by.onliner.page.AbstractPage;
import by.onliner.page.components.Menu;
import by.onliner.page.components.ShoppingCartPopup;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogItemPage extends AbstractPage {

    private ShoppingCartPopup shoppingCartPopup = new ShoppingCartPopup();

    @FindBy(linkText = "В корзину")
    private WebElement addToShoppingCartButton;

    @FindBy(linkText = "В корзине")
    private WebElement greenShoppingCartButton;

    public CatalogItemPage() {
        super();
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
        return new Menu();
    }

    /***
     * Click on the addToShoppingCart button.
     */
    public void addToCart() {
        waitForPageOpened();
        addToShoppingCartButton.click();
        Waiter.waitForVisibility(greenShoppingCartButton);
//        if (shoppingCartPopup.isShoppingCartPopupVisible()) {
//            shoppingCartPopup.closeShoppingCartPopup();
//        }
    }
}
