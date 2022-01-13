package by.onliner.cucumber.steps;

import by.onliner.page.*;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AbstractSteps {

    protected MainPage mainPage = new MainPage();
    protected CatalogItemPage catalogPageItem = new CatalogItemPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    protected AboutCompanyPage aboutCompanyPage = new AboutCompanyPage();
    protected LogInPage logInPage = new LogInPage();

    @Then("Page url should contain {string}")
    public void isPageUrlContainLink(String link) {
        Assert.assertTrue(aboutCompanyPage.isPageOpened(link), "About company page isn't opened");
    }
}
