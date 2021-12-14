package by.onliner.page.pages;

import by.onliner.driver.DriverManager;
import by.onliner.elements.widget.Button;
import by.onliner.elements.widget.Text;
import org.openqa.selenium.support.FindBy;
import by.onliner.page.AbstractPage;
import by.onliner.utils.ActionsHelper;
import by.onliner.utils.Waiter;

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
