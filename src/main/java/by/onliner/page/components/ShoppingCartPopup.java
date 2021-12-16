package by.onliner.page.components;

import by.onliner.elements.widget.Button;
import by.onliner.page.AbstractComponent;
import by.onliner.utils.Waiter;
import io.qameta.allure.Step;
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
           logger.info("Opened 'Shopping cart' popup");
           return shoppingCartPopupCloseButton.isDisplayed();
       } catch (NoSuchElementException | TimeoutException e) {
           return false;
       }
    }

    /***
     * Click on the popup close button.
     */
    @Step("Close shopping cart popup")
    public void closeShoppingCartPopup() {
        shoppingCartPopupCloseButton.click();
        logger.info("Close popup");
    }
}
