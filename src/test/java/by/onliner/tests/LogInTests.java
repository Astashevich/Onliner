package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.test_dev.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static by.onliner.constants.OnlinerConstants.*;
import static by.onliner.constants.TestType.SMOKE;

@Feature("Log-In")
public class LogInTests extends AbstractTest {

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_006] Test for log-In when fields are empty")
    public void login_whenFieldsAreEmptyTest() {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayedAfterTest(), "Log-In page is not displayed after test");
        String actualLogInWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT, String.format("The actual log-in " +
                "warning text [%s] don't much expected warning text [%s]", actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT));
    }

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_007] Test for log-In when password field is empty")
    public void login_whenPasswordFieldIsEmpty() {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.inputLogIn(LOGIN);
        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayedAfterTest(), "Log-In page is not displayed after test");
        String actualPasswordWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualPasswordWarningText, INCORRECT_PASSWORD_WARNING_TEXT, String.format("Actual password " +
                "warning text [%s] don't much expected warning text [%s]", actualPasswordWarningText, INCORRECT_PASSWORD_WARNING_TEXT));
    }

    @TestType(value = SMOKE)
    @Test()
    public void login_whenAfterWrightLoginPutFewGaps() {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.inputLogIn(LOGIN_WITH_FEW_GAPS);
        logInPage.inputPassword(PASSWORD);
        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayedAfterTest(), "Log-In page is not displayed after test");
        String actualLogInWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT, String.format("The actual log-in " +
                "warning text [%s] don't much expected warning text [%s]", actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT));
    }

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_009] Test for log-In when log-In is non-existent")
    public void login_whenLoginIsNonExistent() {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.inputLogIn(faker.internet().emailAddress());
        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayedAfterTest(), "Log-In page is not displayed after test");
        String actualPasswordWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualPasswordWarningText, INCORRECT_PASSWORD_WARNING_TEXT, String.format("Actual password " +
                "warning text [%s] don't much expected warning text [%s]", actualPasswordWarningText, INCORRECT_PASSWORD_WARNING_TEXT));
    }

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_010] Test for log-In when  fields fills by [space]")
    public void login_whenFieldFillsBySpace() {
        mainPage.openPage();
        mainPage.getMenu().openLogInPage();

        logInPage.inputLogIn(SPACE);
        logInPage.inputPassword(SPACE);
        logInPage.clickLogInFormButton();

        Assert.assertTrue(logInPage.isLogInPageDisplayedAfterTest(), "Log-In page is not displayed after test");
        String actualLogInWarningText = logInPage.getInputFieldWarningText();
        Assert.assertEquals(actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT, String.format("The actual log-in " +
                "warning text [%s] don't much expected warning text [%s]", actualLogInWarningText, INCORRECT_LOG_IN_WARNING_TEXT));
    }
}
