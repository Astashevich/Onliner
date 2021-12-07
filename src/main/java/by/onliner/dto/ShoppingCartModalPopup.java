package by.onliner.dto;

import by.onliner.page.AbstractPage;
import by.onliner.page.MainPage;
import by.onliner.page.ShoppingCartPage;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartModalPopup extends AbstractPage {

    @FindBy(className = "product-recommended__sidebar-close")
    WebElement shoppingCartPopupCloseButton;

    public ShoppingCartModalPopup() {
        super();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.elementToBeClickable(shoppingCartPopupCloseButton);
    }

    /***
     * Click on the popup close button.
     */
    public void closeShoppingCartPopup() {
        waitForPageOpened();
        shoppingCartPopupCloseButton.click();
    }


}
