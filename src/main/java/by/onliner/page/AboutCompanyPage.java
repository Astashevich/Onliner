package by.onliner.page;

import by.onliner.core.elements.widget.Text;
import by.onliner.core.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class AboutCompanyPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='news-header__title']/h1")
    private Text pageMessage;

    public static final String ABOUT_LINK = "/about";

    public AboutCompanyPage() {
        super();
    }

    @Override
    protected void waitForPageOpened() {
        Waiter.waitForVisibility(pageMessage);
    }

    /***
     * Check if current url of page contains expected link
     * @return boolean of method
     */
    @Step("Check if the page is opened")
    public boolean isPageOpened(String link) {
        logger.info(String.format("Check the url contains [%s]", link));
        return driver.getCurrentUrl().contains(link);
    }

    /***
     * Read about company page message
     * @return text from message
     */
    @Step("Read about company page message")
    public String getAboutCompanyPageMessage() {
        waitForPageOpened();
        logger.info(String.format("Get page message [%s]", pageMessage.getText().toLowerCase()));
        return pageMessage.getText().toLowerCase();
    }
}
