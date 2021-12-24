package by.onliner.page.components;

import by.onliner.elements.widget.Button;
import by.onliner.elements.widget.Text;
import by.onliner.elements.widget.TextInput;
import by.onliner.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    private Text searchedItemName;

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
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        Waiter.waitForVisibility(searchedItemName);
        String itemName = searchedItemName.getText().toLowerCase();
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
