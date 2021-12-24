package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.core.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static by.onliner.constants.TestType.*;
import static by.onliner.core.utils.EqualsUtil.equalContains;

@Feature("Shopping cart")
public class ShoppingCartTests extends AbstractTest {

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_001] Test for adding item to the shopping cart")
    public void addItemToShoppingCartTest() {
        mainPage.openPage();
        mainPage.openCatalogRandomItem();

        String itemNameFromCatalog = catalogPageItem.getItemName();
        catalogPageItem.addToCart();
        mainPage.getMenu().openShoppingCartPage();

        String itemNameFromCart = shoppingCartPage.getItemName();
        Assert.assertEquals(itemNameFromCatalog, itemNameFromCart, String.format("Item name [%s] don't match " +
                "item name [%s] from shopping cart", itemNameFromCatalog, shoppingCartPage.getItemName()));
        Assert.assertTrue(shoppingCartPage.isCompleteOrderButtonVisible(), "[Перейти к оформлению] button isn't visible");
    }

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_002] Test for removing item from the shopping cart and checking the cart " +
            "for emptiness")
    public void removeItemFromShoppingCartTest() {
        mainPage.openPage();
        mainPage.openCatalogRandomItem();
        catalogPageItem.addToCart();
        mainPage.getMenu().openShoppingCartPage();

        shoppingCartPage.removeItemFromCart();
        String removedItemMessage = shoppingCartPage.getRemovedItemInformation();
        String emptyCartMassage = shoppingCartPage.getEmptyCartMassage();

        Assert.assertTrue(equalContains(removedItemMessage, "Вы удалили"), String.format("The message [%s]" +
                " wasn't contains at expected removed message [%s]", removedItemMessage, "Вы удалили"));
        Assert.assertTrue(equalContains(emptyCartMassage, "Ваша корзина пуста"), String.format("The message " +
                "[%s] wasn't contains at expected empty cart message [%s]", emptyCartMassage, "Ваша корзина пуста"));
    }

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_003] Test for adding one more same item in the shopping cart by \"+\" button")
    public void addOneMoreSameItemInCartByTest() {
        mainPage.openPage();
        mainPage.openCatalogRandomItem();
        catalogPageItem.addToCart();
        mainPage.getMenu().openShoppingCartPage();

        int itemPrice = shoppingCartPage.getPrice();
        shoppingCartPage.clickQuantityInputPlusButton();
        int numberFromQuantityInput = shoppingCartPage.getNumberFromQuantityInput();
        int itemPriceAfterAddingItem = shoppingCartPage.getPrice();

        Assert.assertEquals(numberFromQuantityInput, 2, String.format("The number [%d] from quantity input don't" +
                " match [2]",numberFromQuantityInput));
        Assert.assertEquals(itemPriceAfterAddingItem, itemPrice*2, String.format("The price [%d] after " +
                "adding the same item was match first price [%d]", itemPriceAfterAddingItem, itemPrice));
    }
}
