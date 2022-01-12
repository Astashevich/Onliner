package by.onliner.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LogInSteps extends AbstractSteps{

    @Given("Open log-In page")
    public void openLogInPage() {
        mainPage.getMenu().openLogInPage();
    }

    @When("Click log-In form button")
    public void clickLogInFormButton() {
        logInPage.clickLogInFormButton();
    }

    @Then("Verify warning message matches {string}")
    public void isTheActualLogInWarningTextMuchTheExpectedWarningText(String expectedMessage) {
        String actualLogInWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualLogInWarningText, expectedMessage, String.format("The actual log-in " +
                "warning text [%s] don't much expected warning text [%s]", actualLogInWarningText, expectedMessage));
    }

    @When("Input login {string} in log-in input field")
    public void inputLoginInLogInInputField(String login) {
        logInPage.inputLogIn(login);
    }

    @Then("Chek log-In form is visible")
    public void chekLogInFormIsVisible() {
        Assert.assertTrue(logInPage.isLogInPageDisplayed(), "Log-In page is not displayed after test");
    }

    @When("Input password {string} in password input field")
    public void inputPasswordInPasswordInputField(String text) {
        logInPage.inputPassword(text);
    }
}
