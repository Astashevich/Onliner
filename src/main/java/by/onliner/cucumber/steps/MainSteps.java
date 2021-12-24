package by.onliner.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static by.onliner.utils.EqualsUtil.equalContains;

public class MainSteps extends AbstractSteps{

    @When("Click [О компании] link")
    public void clickOnAboutCompanyLink() {
        mainPage.getFooter().clickOnAboutCompanyLink();
    }

    @Then("Page url should contain [about]")
    public void pageUrlShouldContainAbout() {
        aboutCompanyPage.isPageOpened();
    }

    @And("Page message should contain {string}")
    public void pageMessageShouldContain(String expectedText) {
        String actualPageMessage = aboutCompanyPage.getAboutCompanyPageMessage();
        Assert.assertTrue(equalContains(expectedText, actualPageMessage),
                String.format("The page message [%s] don't contain [%s]", actualPageMessage, expectedText));
    }
}
