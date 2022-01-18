package by.onliner.page.components;

import by.onliner.core.elements.widget.Button;
import by.onliner.core.elements.widget.Text;
import by.onliner.core.elements.widget.TextInput;
import by.onliner.core.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractComponent {

    private static final int MAX_LIST_SIZE_ITEMS_ON_PAGE = 6;

    @FindBy(className = "auth-bar__item--cart")
    private Button shoppingCartButton;

    @FindBy(className = "auth-bar__item--text")
    private Button entranceButton;

    @FindBy(className = "fast-search__input")
    private TextInput mainSearchField;

    @FindBy(className = "product__title-link")
    private Text searchedItemNameText;

    @FindBy(className = "modal-iframe")
    private WebElement searchFieldFrame;

    public Menu() {
        super();
    }

    @Override
    public void waitForComponentOpened() {
        Waiter.waitForVisibility(shoppingCartButton);
    }

    /***
     * Click on the shopping cart button.
     */
    @Step("Open shopping cart page")
    public void openShoppingCartPage() {
        waitForComponentOpened();
        shoppingCartButton.click();
        logger.info("Click 'Shopping cart' button");
    }

    /***
     * Input text in the search field
     * @param text item what we need to find
     */
    @Step("Input text in the search field")
    public void inputTextInSearchField(String text) {
        waitForComponentOpened();
        mainSearchField.sendKeys(text);
        logger.info("Input [" + text + "] in the search field");
    }

    /***
     * Get name of the first searched item
     * @return name of searched item
     */
    @Step("Read name of the first searched item")
    public String getNameOfSearchedItem() {
        driver.switchTo().frame(searchFieldFrame);
        Waiter.waitForVisibility(searchedItemNameText);
        String itemName = searchedItemNameText.getText().toLowerCase();
        logger.info("Get name [" + itemName + "] of searched item");
        return itemName;
    }

    /***
     * Click entrance button and open log-in page
     */
    @Step("Open log-in page")
    public void openLogInPage() {
        waitForComponentOpened();
        entranceButton.click();
        logger.info("Click 'Вход' button");
    }
}
