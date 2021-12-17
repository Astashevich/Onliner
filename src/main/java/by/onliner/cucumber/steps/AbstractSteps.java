package by.onliner.cucumber.steps;

import by.onliner.page.CatalogItemPage;
import by.onliner.page.MainPage;
import by.onliner.page.ShoppingCartPage;

public class AbstractSteps {

    protected MainPage mainPage = new MainPage();
    protected CatalogItemPage catalogPageItem = new CatalogItemPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
}
