package by.onliner.cucumber.steps;

import by.onliner.page.site.CatalogItemPage;
import by.onliner.page.site.MainPage;
import by.onliner.page.site.ShoppingCartPage;

public class AbstractSteps {

    protected MainPage mainPage = new MainPage();
    protected CatalogItemPage catalogPageItem = new CatalogItemPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
}
