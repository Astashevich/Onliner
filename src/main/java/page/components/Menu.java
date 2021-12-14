package page.components;

import elements.widget.Button;
import elements.widget.EntryField;
import org.openqa.selenium.support.FindBy;
import page.AbstractComponent;
import utils.Waiter;

public class Menu extends AbstractComponent {

    @FindBy(className = "auth-bar__item--cart")
    private Button shoppingCartButton;

    @FindBy(className = "auth-bar__item--text")
    private Button entranceButton;

    @FindBy(className = "fast-search__input")
    private EntryField mainSearchField;

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
