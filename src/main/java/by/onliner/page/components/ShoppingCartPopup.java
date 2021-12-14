package by.onliner.page.components;

import by.onliner.elements.widget.Button;
import by.onliner.page.AbstractComponent;
import by.onliner.utils.Waiter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPopup extends AbstractComponent {

    @FindBy(className = "product-recommended__sidebar-close")
    private Button shoppingCartPopupCloseButton;

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
       try {
           Waiter.waitForVisibility(shoppingCartPopupCloseButton, 1);
           return shoppingCartPopupCloseButton.isDisplayed();
       } catch (NoSuchElementException | TimeoutException e) {
           return false;
       }
    }

    /***
     * Click on the popup close button.
     */
    public void closeShoppingCartPopup() {
        shoppingCartPopupCloseButton.click();
    }
}
