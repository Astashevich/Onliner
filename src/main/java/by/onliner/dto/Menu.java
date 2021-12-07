package by.onliner.dto;

import by.onliner.page.AbstractPage;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractPage {

    @FindBy(className = "auth-bar__item--cart")
    private WebElement shoppingCartButton;

    @FindBy(className = "auth-bar__item--text")
    private WebElement entranceButton;

    @FindBy(className = "fast-search__input")
    private WebElement mainSearchField;

    public Menu() {
        super();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(shoppingCartButton);
    }

    /***
     * Click on the shopping cart button.
     */
    public void openShoppingCartPage() {
        shoppingCartButton.click();
    }
}
