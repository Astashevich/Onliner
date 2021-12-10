package by.onliner.page.components;

import by.onliner.page.AbstractComponent;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPopup extends AbstractComponent {

    @FindBy(className = "product-recommended__sidebar-close")
    private WebElement shoppingCartPopupCloseButton;

    public ShoppingCartPopup() {
        super();
    }

    @Override
    public void waitForComponentOpened() {
        Waiter.elementToBeClickable(shoppingCartPopupCloseButton);
    }

    /***
     * Checks if a Shopping cart popup is visible
     * @return visibility of popup
     */
    public boolean isShoppingCartPopupVisible() {
        return shoppingCartPopupCloseButton.isDisplayed();
    }

    /***
     * Click on the popup close button.
     */
    public void closeShoppingCartPopup() {
        shoppingCartPopupCloseButton.click();
    }
}
