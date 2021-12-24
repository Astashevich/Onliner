package by.onliner.page.components;

import by.onliner.elements.widget.Link;
import by.onliner.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractComponent{

    @FindBy(xpath = "//a[contains(., 'О компании')]")
    private Link aboutCompanyLink;

    public Footer() {
        super();
    }

    @Override
    protected void waitForComponentOpened() {
        Waiter.waitForVisibility(aboutCompanyLink);
    }

    /***
     * CLick on about company link
     */
    @Step("Click on 'О компании' link")
    public void clickOnAboutCompanyLink() {
        aboutCompanyLink.click();
        logger.info("Click on [О компании] link");
    }
}
