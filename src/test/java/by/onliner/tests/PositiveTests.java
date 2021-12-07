package by.onliner.tests;

import by.onliner.driver.DriverManager;
import by.onliner.dto.Menu;
import by.onliner.dto.ShoppingCartModalPopup;
import by.onliner.page.CatalogPageItem;
import by.onliner.page.MainPage;
import by.onliner.page.ShoppingCartPage;
import by.onliner.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests extends AbstractTest{

    @Test(description = "Test for removing item from the shopping cart and checking the cart for emptiness")
    public void removeItemFromShoppingCartTest() {
        //given
        MainPage mainPage = new MainPage();
        Menu menu = new Menu();
        CatalogPageItem catalogPageItem = new CatalogPageItem();
        ShoppingCartModalPopup shoppingCartModalPopup = new ShoppingCartModalPopup();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        mainPage.openPage();
        menu.waitForPageOpened();
        mainPage.openCatalogFirstItem();
        catalogPageItem.waitForPageOpened();
        catalogPageItem.addToCart();
        shoppingCartModalPopup.closeShoppingCartPopup();
        menu.waitForPageOpened();
        menu.openShoppingCartPage();

        //when
        shoppingCartPage.waitForPageOpened();
        shoppingCartPage.removeItemFromCart();
        String removedItemMessage = shoppingCartPage.getRemovedItemInformation();
        DriverManager.getDriver().navigate().refresh();
        String emptyCartMassage = shoppingCartPage.getEmptyCartMassage();

        //then
        Assert.assertTrue(Assertions.assertContain(removedItemMessage, "Вы удалили"));
        Assert.assertTrue(Assertions.assertContain(emptyCartMassage, "Ваша корзина пуста"));
    }
}
