package page.pages;

import driver.DriverManager;
import elements.widget.Button;
import elements.widget.Text;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import utils.ActionsHelper;
import utils.Waiter;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'cart-form__title')]")
    private Text openedShoppingCartMessage;

    @FindBy(className = "cart-form__control")
    private Button removeFromCartButton;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__description_condensed-extra')]")
    private Text removedItemInformation;

    @FindBy(xpath = "//div[contains(@class, 'cart-message__title_big')]")
    private Text emptyCartMessage;

    public ShoppingCartPage() {
        super();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.elementToBeClickable(openedShoppingCartMessage);
    }

    /***
     * Click on the bucket icon.
     */
    public void removeItemFromCart() {
        Waiter.waitForVisibility(removeFromCartButton);
        ActionsHelper.moveToElementAndClick(removeFromCartButton);
    }

    /***
     * Get a message from removed item.
     */
    public String getRemovedItemInformation() {
        Waiter.elementToBeClickable(removedItemInformation);
        return removedItemInformation.getText();
    }

    /***
     * Get a message from empty cart.
     */
    public String getEmptyCartMassage() {
        DriverManager.getDriver().navigate().refresh();
        Waiter.waitForVisibility(emptyCartMessage);
        return emptyCartMessage.getText();
    }
}
