package by.onliner.page.components;

import by.onliner.page.AbstractComponent;
import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractComponent {

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
    public void waitForComponentOpened() {
        Waiter.waitForVisibility(shoppingCartButton);
    }

    /***
     * Click on the shopping cart button.
     */
    public void openShoppingCartPage() {
        waitForComponentOpened();
        shoppingCartButton.click();
    }
}
