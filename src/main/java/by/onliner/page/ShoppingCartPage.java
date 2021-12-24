package by.onliner.page;

import by.onliner.driver.DriverManager;
import by.onliner.elements.widget.Button;
import by.onliner.elements.widget.Text;
import by.onliner.elements.widget.TextInput;
import by.onliner.utils.ActionsHelper;
import by.onliner.utils.Waiter;
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

    @FindBy(css = ".cart-form__description_condensed-other .cart-form__link_base-alter")
    private Text itemName;

    @FindBy(xpath = "//a[contains(@class, 'cart-form__button') and text()]")
    private Button completeOrderButton;

    @FindBy(xpath = "//a[contains(@class, 'cart-form__button_increment')]")
    private Button quantityInputPlusButton;

    @FindBy(xpath = "//input[contains(@class, 'cart-form__input_nonadaptive')]")
    private TextInput quantityInput;

    @FindBy(xpath = "//div[contains(@class, 'helpers_hide_tablet')]/div[contains(@class, 'cart-form__description_condensed-another')]/span")
    private Text itemPrice;

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

    /***
     * Get the item name from shopping cart list.
     * @return name of the item
     */
    @Step("Read the item name")
    public String getItemName() {
        Waiter.waitForVisibility(itemName);
        logger.info(String.format("Read the item name [%s] from shopping cart", itemName.getText()));
        return itemName.getText().trim();
    }

    /***
     * Check the complete order button fo visibility.
     * @return visibility of button
     */
    @Step("Chek [Перейти к оформлению] button for visibility")
    public boolean isCompleteOrderButtonVisible() {
        boolean visibility = completeOrderButton.isDisplayed();
        if (visibility) {
            logger.info("'Перейти к оформлению' button is visible");
        }
        return visibility;
    }

    /***
     * Add one more same item in the shopping cart by [+] button
     */
    @Step("Add one more same item in the shopping cart by [+] button")
    public void clickQuantityInputPlusButton() {
        Waiter.elementToBeClickable(quantityInputPlusButton);
        quantityInputPlusButton.click();
        logger.info("Click '+' button");
        Waiter.sleep(2);
    }

    /***
     * Get number from quantity input
     * @return integer number from quantity input
     */
    @Step("Get number from quantity input")
    public int getNumberFromQuantityInput() {
        Waiter.waitForVisibility(quantityInput);
        logger.info("Get number [" + quantityInput.getAttribute("value") + "] from quantity input");
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    /***
     * Get price of item
     * @return integer price of item
     */
    @Step("Get price")
    public int getPrice() {
        Waiter.waitForVisibility(itemPrice);
        int price = Integer.parseInt(itemPrice.getText().substring(0, itemPrice.getText().length() - 6));
        logger.info(String.format("Get price [%d]", price));
        return price;
    }
}
