package by.onliner.cucumber.steps;

import by.onliner.page.pages.CatalogItemPage;
import by.onliner.page.pages.MainPage;
import by.onliner.page.pages.ShoppingCartPage;

public class AbstractSteps {

    protected MainPage mainPage = new MainPage();
    protected CatalogItemPage catalogPageItem = new CatalogItemPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
}
