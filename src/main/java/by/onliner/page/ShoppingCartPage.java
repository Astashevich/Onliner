package by.onliner.page;

import by.onliner.util.MoveTo;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'cart-form__title')]")
    WebElement openedShoppingCartMessage;

    @FindBy(className = "cart-form__control")
    WebElement removeFromCartButton;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__offers-unit_primary')]")
    WebElement Item;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__description_condensed-extra')]")
    WebElement removedItemInformation;

    @FindBy(xpath = "//div[contains(@class, 'cart-message__title_big')]")
    WebElement emptyCartMessage;

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
        MoveTo.moveToElementAndClick(removeFromCartButton);
        //MoveTo.clickElement(removeFromCartButton);
        //removeFromCartButton.click();
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
        Waiter.waitForVisibility(emptyCartMessage);
        return emptyCartMessage.getText();
    }
}
