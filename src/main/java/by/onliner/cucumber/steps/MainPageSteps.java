package by.onliner.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static by.onliner.core.utils.EqualsUtil.equalContains;

public class MainPageSteps extends AbstractSteps{

    @When("Click [О компании] link")
    public void clickOnAboutCompanyLink() {
        mainPage.getFooter().clickOnAboutCompanyLink();
    }

    @Then("Page url should contain {string}")
    public void isPageUrlContainLink(String link) {
        aboutCompanyPage.isPageOpened(link);
    }

    @And("Page message should contain {string}")
    public void isPageMessageContainExpectedMessage(String expectedText) {
        String actualPageMessage = aboutCompanyPage.getAboutCompanyPageMessage();
        Assert.assertTrue(equalContains(expectedText, actualPageMessage),
                String.format("The page message [%s] don't contain [%s]", actualPageMessage, expectedText));
    }
}
