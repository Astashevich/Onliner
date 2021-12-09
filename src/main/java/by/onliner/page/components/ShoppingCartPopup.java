package by.onliner.page.components;

import by.onliner.page.AbstractComponent;
import by.onliner.util.Waiter;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static java.util.concurrent.TimeUnit.SECONDS;

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

    public boolean visibilityOfShoppingCartPopup() {
        try {
            Awaitility.await()
                    .atMost(5, SECONDS)
                    .atLeast(1, SECONDS)
                    .pollInterval(1, SECONDS)
                    .until(() -> shoppingCartPopupCloseButton.isDisplayed());
            return true;
        } catch (Exception e) {
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
