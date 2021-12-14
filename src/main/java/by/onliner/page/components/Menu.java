package by.onliner.page.components;

import by.onliner.elements.widget.Button;
import by.onliner.elements.widget.TextInput;
import org.openqa.selenium.support.FindBy;
import by.onliner.page.AbstractComponent;
import by.onliner.utils.Waiter;

public class Menu extends AbstractComponent {

    @FindBy(className = "auth-bar__item--cart")
    private Button shoppingCartButton;

    @FindBy(className = "auth-bar__item--text")
    private Button entranceButton;

    @FindBy(className = "fast-search__input")
    private TextInput mainSearchField;

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
