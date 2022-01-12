package by.onliner.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static by.onliner.core.utils.EqualsUtil.equalContains;

public class CatalogSteps extends AbstractSteps {

    @When("Input {string} in search input field")
    public void inputTextInSearchField(String text) {
        mainPage.getMenu().inputTextInSearchField(text);
    }

    @Then("Verify searched item name contains {string}")
    public void isSearchedItemContainName(String itemName) {
        String foundItemName = mainPage.getMenu().getNameOfSearchedItem();
        Assert.assertTrue(equalContains(foundItemName, itemName), String.format("Searched item name [%s] wasn't contain [%s]",
                foundItemName, itemName));
    }
}
