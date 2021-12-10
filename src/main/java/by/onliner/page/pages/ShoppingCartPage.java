package by.onliner.page.pages;

import by.onliner.driver.DriverManager;
import by.onliner.page.AbstractPage;
import by.onliner.util.ActionsHelper;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'cart-form__title')]")
    private WebElement openedShoppingCartMessage;

    @FindBy(className = "cart-form__control")
    private WebElement removeFromCartButton;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__offers-unit_primary')]")
    private WebElement cartUnitForm;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__description_condensed-extra')]")
    private WebElement removedItemInformation;

    @FindBy(xpath = "//div[contains(@class, 'cart-message__title_big')]")
    private WebElement emptyCartMessage;

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
