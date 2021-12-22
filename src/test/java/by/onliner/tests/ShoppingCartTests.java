package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.test_dev.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static by.onliner.constants.TestType.*;
import static by.onliner.utils.EqualsUtil.equalContains;

@Feature("Shopping cart")
public class ShoppingCartTests extends AbstractTest {

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
}
