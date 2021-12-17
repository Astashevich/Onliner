package by.onliner.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static by.onliner.utils.EqualsUtil.equalContains;

public class ShoppingCartSteps extends AbstractSteps {


    @Given("Open main page: Onliner.by")
    public void openMainPage() {
        mainPage.openPage();
    }

    @And("Open catalog random item")
    public void openCatalogRandomItem() {
        mainPage.openCatalogRandomItem();
    }

    @And("Add item to the shopping cart")
    public void addToCart() {
        catalogPageItem.addToCart();
    }

    @And("Open shopping cart page")
    public void openShoppingCartPage() {
        mainPage.getMenu().openShoppingCartPage();
    }

    @When("Remove item from the shopping cart")
    public void removeItemFromCart() {
        shoppingCartPage.removeItemFromCart();
    }

    @Then("Appeared information should contain [Вы удалили]")
    public void checkedRemovedItemInfo() {
        String removedItemMessage = shoppingCartPage.getRemovedItemInformation();
        Assert.assertTrue(equalContains(removedItemMessage, "Вы удалили"),
                String.format("The message [%s] wasn't contains at expected removed message [%s...]",
                        removedItemMessage, "Вы удалили"));
    }

    @And("Expected empty cart message should contain [Ваша корзина пуста]")
    public void checkedEmptyCartMessage() {
        String emptyCartMassage = shoppingCartPage.getEmptyCartMassage();
        Assert.assertTrue(equalContains(emptyCartMassage, "Ваша корзина пуста"),
                String.format("The message [%s] wasn't contains at expected empty cart message [%s]",
                        emptyCartMassage, "Ваша корзина пуста"));
    }
}
