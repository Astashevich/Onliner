package by.onliner.cucumber.steps;

import by.onliner.cucumber.testContext.Context;
import by.onliner.cucumber.testContext.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static by.onliner.core.utils.EqualsUtil.equalContains;

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

    @Then("Appeared information should contain {string}")
    public void checkedRemovedItemInfo(String expectedMessage) {
        String removedItemMessage = shoppingCartPage.getRemovedItemInformation();
        Assert.assertTrue(equalContains(removedItemMessage, expectedMessage),
                String.format("The message [%s] wasn't contains at expected removed message [%s...]",
                        removedItemMessage, expectedMessage));
    }

    @And("Expected empty cart message should contain {string}")
    public void checkedEmptyCartMessage(String expectedMessage) {
        String emptyCartMassage = shoppingCartPage.getEmptyCartMassage();
        Assert.assertTrue(equalContains(emptyCartMassage, expectedMessage),
                String.format("The message [%s] wasn't contains at expected empty cart message [%s]",
                        emptyCartMassage, expectedMessage));
    }

    @When("Get item name")
    public void getItemName() {
        ScenarioContext.getScenarioContext().setContext(Context.ITEM_NAME, catalogPageItem.getItemName());
    }

    @Then("Item name from shopping cart must match the chosen item from catalog")
    public void isItemNameFromShoppingCartMatchTheChosenItemFromCatalog() {
        String itemNameFromCatalog = String.valueOf(ScenarioContext.getScenarioContext().getContext(Context.ITEM_NAME));
        String itemNameFromCart = shoppingCartPage.getItemNameText();
        Assert.assertEquals(itemNameFromCatalog, itemNameFromCart, String.format("Item name [%s] don't match " +
                "item name [%s] from shopping cart", itemNameFromCatalog, itemNameFromCart));
    }

    @Then("[Перейти к оформлению] button should be visible")
    public void isCompleteOrderButtonVisible() {
        Assert.assertTrue(shoppingCartPage.isCompleteOrderButtonVisible(), "[Перейти к оформлению] button isn't " +
                "visible");
    }

    @When("Get item price")
    public void getItemPrice() {
        ScenarioContext.getScenarioContext().setContext(Context.PRICE, shoppingCartPage.getPrice());
    }

    @And("Click + button")
    public void clickPlusButton() {
        shoppingCartPage.clickQuantityInputPlusButton();
    }

    @Then("The number from quantity input will match [{int}]")
    public void isTheNumberFromQuantityInputMatchExpectedNumber(int expectedNumber) {
        double numberFromQuantityInput = shoppingCartPage.getNumberFromQuantityInput();
        Assert.assertEquals(numberFromQuantityInput, expectedNumber, String.format("The number [%f] from quantity input don't" +
                " match [%d]",numberFromQuantityInput, expectedNumber));
    }

    @And("The price after adding the same item shouldn't match first price*{int}")
    public void isThePriceAfterAddingTheSameItemNotMatchFirstPrice(int arg) {
        double itemPrice = (Double) ScenarioContext.getScenarioContext().getContext(Context.PRICE);
        double itemPriceAfterAddingItem = shoppingCartPage.getPrice();
        Assert.assertEquals(itemPriceAfterAddingItem, itemPrice*arg, String.format("The price [%f] after " +
                "adding the same item shouldn't match first price [%f]", itemPriceAfterAddingItem, itemPrice));
    }
}
