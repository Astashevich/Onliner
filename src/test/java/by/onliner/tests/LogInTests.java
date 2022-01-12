package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.core.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.onliner.constants.TestType.SMOKE;

@Feature("Log-In")
public class LogInTests extends AbstractTest {

    private static final String INCORRECT_LOG_IN_WARNING_TEXT = "укажите ник или e-mail";
    private static final String INCORRECT_PASSWORD_WARNING_TEXT = "укажите пароль";

    private static final String LOGIN = "vs2450439@gmail.com";
    private static final String PASSWORD = "hqhTqwje872H";
    private static final String LOGIN_WITH_FEW_GAPS = "  vs2450439@gmail.com   ";
    private static final String SPACE = " ";

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:[Test-Case ID:ONL_006-ONL_010] Test of log-In form with incorrect test data",
            dataProvider = "getTestData")
    public void logInWithIncorrectDataTest(String login, String password, String expectedMessage) {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.inputLogIn(login);
        logInPage.inputPassword(password);
        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayed(), "Log-In page is not displayed after test");
        String actualLogInWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualLogInWarningText, expectedMessage, String.format("The actual log-in " +
                "warning text [%s] don't much expected warning text [%s]", actualLogInWarningText, expectedMessage));
    }

    @DataProvider
    private Object[][] getTestData() {
        return new Object[][]{
                {"", "", INCORRECT_LOG_IN_WARNING_TEXT},
                {LOGIN, "", INCORRECT_PASSWORD_WARNING_TEXT},
                {LOGIN_WITH_FEW_GAPS, PASSWORD, INCORRECT_LOG_IN_WARNING_TEXT},
                {faker.internet().emailAddress(), "", INCORRECT_PASSWORD_WARNING_TEXT},
                {SPACE, SPACE, INCORRECT_LOG_IN_WARNING_TEXT}
        };
    }
}
