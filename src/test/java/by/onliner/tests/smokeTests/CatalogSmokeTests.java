package by.onliner.tests.smokeTests;

import by.onliner.page.pages.CatalogPageItem;
import by.onliner.page.pages.ShoppingCartPage;
import by.onliner.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static by.onliner.util.EqualsUtil.equalContains;

public class CatalogSmokeTests extends AbstractTest {

    @Test(groups = "positiveTests", description = "[Test-Case ID:ONL_002] Test for removing item from the shopping cart " +
            "and checking the cart for emptiness")
    public void removeItemFromShoppingCartTest() {
        CatalogPageItem catalogPageItem = new CatalogPageItem();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        mainPage.openPage();
        mainPage.getMenu().waitForComponentOpened();
        mainPage.openCatalogFirstItem();
        catalogPageItem.addToCart();
        mainPage.getMenu().openShoppingCartPage();

        shoppingCartPage.removeItemFromCart();
        String removedItemMessage = shoppingCartPage.getRemovedItemInformation();
        String emptyCartMassage = shoppingCartPage.getEmptyCartMassage();

        Assert.assertTrue(equalContains(removedItemMessage, "Вы удалили"), "The message \""
                + removedItemMessage + "\" wasn't contains at expected removed message \"Вы удалили...\"");
        Assert.assertTrue(equalContains(emptyCartMassage, "Ваша корзина пуста"), "The message \""
                + emptyCartMassage + "\" wasn't contains at expected empty cart message \"Ваша корзина пуста\"");
    }
}
