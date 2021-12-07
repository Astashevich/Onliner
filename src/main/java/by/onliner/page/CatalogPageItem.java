package by.onliner.page;


import by.onliner.util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPageItem extends AbstractPage{

    @FindBy(linkText = "В корзину")
    private WebElement addToShoppingCartButton;

    @FindBy(linkText = "В корзине")
    private WebElement greenShoppingCartButton;

    public CatalogPageItem(){
        super();
    }

    @Override
    public void waitForPageOpened() {
        Waiter.waitForVisibility(addToShoppingCartButton);
    }

    /***
     * Click on the addToShoppingCart button.
     */
    public void addToCart() {
        addToShoppingCartButton.click();
        Waiter.waitForVisibility(greenShoppingCartButton);
    }

}
