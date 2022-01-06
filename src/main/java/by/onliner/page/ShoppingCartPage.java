package by.onliner.page;

import by.onliner.core.driver.DriverManager;
import by.onliner.core.elements.widget.Button;
import by.onliner.core.elements.widget.Text;
import by.onliner.core.utils.ActionsHelper;
import by.onliner.core.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

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
    @Step("Remove item from the shopping cart")
    public void removeItemFromCart() {
        Waiter.waitForVisibility(removeFromCartButton);
        ActionsHelper.moveToElementAndClick(removeFromCartButton);
        logger.info("Click 'remove from cart' button");
    }

    /***
     * Get a message from removed item.
     */
    @Step("Read removed item information")
    public String getRemovedItemInformation() {
        Waiter.elementToBeClickable(removedItemInformation);
        logger.info(String.format("Displayed [%s] message", removedItemInformation.getText()));
        return removedItemInformation.getText();
    }

    /***
     * Get a message from empty cart.
     */
    @Step("Read the empty cart message")
    public String getEmptyCartMassage() {
        DriverManager.getDriver().navigate().refresh();
        Waiter.waitForVisibility(emptyCartMessage);
        logger.info(String.format("Displayed [%s] message", emptyCartMessage.getText()));
        return emptyCartMessage.getText();
    }
}
