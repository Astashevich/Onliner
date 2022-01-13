package by.onliner.page;

import by.onliner.core.driver.DriverManager;
import by.onliner.core.elements.widget.Button;
import by.onliner.core.elements.widget.Text;
import by.onliner.core.elements.widget.TextInput;
import by.onliner.core.utils.ActionsHelper;
import by.onliner.core.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartPage extends AbstractPage {

    private static final String priceRegexPattern = "^[0-9]+";

    @FindBy(xpath = "//div[contains(@class, 'cart-form__title')]")
    private Text openedShoppingCartMessage;

    @FindBy(className = "cart-form__control")
    private Button removeFromCartButton;

    @FindBy(xpath = "//div[contains(@class, 'cart-form__description_condensed-extra')]")
    private Text removedItemInformation;

    @FindBy(xpath = "//div[contains(@class, 'cart-message__title_big')]")
    private Text emptyCartMessage;

    @FindBy(css = ".cart-form__description_condensed-other .cart-form__link_base-alter")
    private Text itemNameText;

    @FindBy(xpath = "//a[contains(@class, 'cart-form__button') and text()]")
    private Button completeOrderButton;

    @FindBy(xpath = "//a[contains(@class, 'cart-form__button_increment')]")
    private Button quantityInputPlusButton;

    @FindBy(xpath = "//input[contains(@class, 'cart-form__input_nonadaptive')]")
    private TextInput quantityInput;

    @FindBy(xpath = "//div[contains(@class, 'helpers_hide_tablet')]/div[contains(@class, 'cart-form__description_condensed-another')]/span")
    private Text itemPriceText;

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
    @Step("Get the empty cart message")
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
    @Step("Get the item name")
    public String getItemNameText() {
        Waiter.waitForVisibility(itemNameText);
        logger.info(String.format("Read the item name [%s] from shopping cart", itemNameText.getText()));
        return itemNameText.getText().trim();
    }

    /***
     * Check the complete order button fo visibility.
     * @return visibility of button
     */
    @Step("Chek [Перейти к оформлению] button for visibility")
    public boolean isCompleteOrderButtonVisible() {
        boolean visibility = completeOrderButton.isDisplayed();
        logger.info(String.format("'Перейти к оформлению' button visibility is {%s}", visibility));
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
        String quantityInputAttribute = quantityInput.getAttribute("value");
        logger.info(String.format("Get number [%s] from quantity input", quantityInputAttribute));
        return Integer.parseInt(quantityInputAttribute);
    }

    /***
     * Get price of item
     * @return integer price of item
     */
    @Step("Get price")
    public int getPrice() {
        Waiter.waitForVisibility(itemPriceText);
        Pattern pattern = Pattern.compile(priceRegexPattern);
        Matcher matcher = pattern.matcher(itemPriceText.getText());
        matcher.find();
        int price = Integer.parseInt(matcher.group());
        logger.info(String.format("Get price [%d]", price));
        return price;
    }
}
