package by.onliner.page;

import by.onliner.elements.widget.Text;
import by.onliner.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static by.onliner.constants.OnlinerConstants.ABOUT_LINK;

public class AboutCompanyPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='news-header__title']/h1")
    private Text pageMessage;

    public AboutCompanyPage() {
        super();
    }

    @Override
    protected void waitForPageOpened() {
        Waiter.waitForVisibility(pageMessage);
    }

    /***
     * Read current url of page
     * @return boolean of method
     */
    @Step("Check if the page is open")
    public boolean isPageOpened() {
        logger.info(String.format("Check the url on contain [%s]", ABOUT_LINK));
        return driver.getCurrentUrl().contains(ABOUT_LINK);
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
