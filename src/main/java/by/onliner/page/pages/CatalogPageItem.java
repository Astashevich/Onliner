package by.onliner.page.pages;

import by.onliner.page.AbstractPage;
import by.onliner.page.components.ShoppingCartPopup;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPageItem extends AbstractPage {

    private ShoppingCartPopup shoppingCartPopup = new ShoppingCartPopup();

    @FindBy(linkText = "В корзину")
    private WebElement addToShoppingCartButton;

    @FindBy(linkText = "В корзине")
    private WebElement greenShoppingCartButton;

    public CatalogPageItem() {
        super();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(addToShoppingCartButton);
    }

    /***
     * Click on the addToShoppingCart button.
     */
    public void addToCart() {
        waitForPageOpened();
        addToShoppingCartButton.click();
        Waiter.waitForVisibility(greenShoppingCartButton);
        if (shoppingCartPopup.visibilityOfShoppingCartPopup()) {
            shoppingCartPopup.closeShoppingCartPopup();
        }
    }
}
