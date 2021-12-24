package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.core.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static by.onliner.constants.TestType.SMOKE;
import static by.onliner.core.utils.EqualsUtil.equalContains;

@Feature("Main")
public class MainTests extends AbstractTest {

    @TestType(value = SMOKE)
    @Test(description = "[Test-Case ID:ONL_005] Test for opening the 'About' page")
    public void openAboutPageFromFooter() {
        mainPage.openPage();

        mainPage.getFooter().clickOnAboutCompanyLink();
        String actualPageMessage = aboutCompanyPage.getAboutCompanyPageMessage();

        Assert.assertTrue(aboutCompanyPage.isPageOpened(), "About company page isn't opened");
        Assert.assertTrue(equalContains("о сайте", actualPageMessage),
                String.format("The page message [%s] don't contain [%s]", actualPageMessage, "о сайте"));
    }
}
