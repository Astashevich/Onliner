package by.onliner.page;

import by.onliner.core.elements.widget.Button;
import by.onliner.core.elements.widget.Text;
import by.onliner.core.elements.widget.TextInput;
import by.onliner.core.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private TextInput logInInput;

    @FindBy(xpath = "//input[@type='password']")
    private TextInput passwordInput;

    @FindBy(xpath = "//button[contains(@class, 'auth-form__button')]")
    private Button loginFormButton;

    @FindBy(xpath = "//div[contains(@class, 'auth-form__description_extended-other')]")
    private Text inputFieldWarningText;

    public LogInPage() {
        super();
    }

    @Override
    protected void waitForPageOpened() {
        Waiter.elementToBeClickable(loginFormButton);
    }

    /***
     * Input text in the log-in field
     * @param text test-passed
     */
    @Step("Input text in the log-in input field")
    public void inputLogIn(String text) {
        waitForPageOpened();
        logInInput.sendKeys(text);
        logger.info(String.format("Input [%s] in the log-in input field", text));
    }

    /***
     * Input text in the password field
     * @param text test-passed
     */
    @Step("Input text in the password input field")
    public void inputPassword(String text) {
        waitForPageOpened();
        passwordInput.sendKeys(text);
        logger.info(String.format("Input [%s] in the password input field", text));
    }

    /***
     * Submit form by clicking 'Войти' button
     */
    @Step("Submit form by clicking 'Войти' button")
    public void clickLogInFormButton() {
        waitForPageOpened();
        loginFormButton.click();
        logger.info("Click 'Войти' button");
    }

    public boolean isLogInPageDisplayed() {
        try {
            Waiter.sleep(1);
            logger.info("Checks log-In page on visible");
            return loginFormButton.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /***
     * Get a warning message under log-in input field
     * @return string of text element
     */
    @Step("Read the warning text under log-in field")
    public String getInputFieldWarningText() {
        Waiter.waitForVisibility(inputFieldWarningText);
        logger.info("Get a warning text under input field");
        return inputFieldWarningText.getText().toLowerCase().trim();
    }
}
