package by.onliner.tests;

import by.onliner.AbstractTest;
import by.onliner.core.anotation.TestType;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static by.onliner.constants.OnlinerConstants.IPHONE;
import static by.onliner.constants.TestType.SMOKE;
import static by.onliner.constants.TestType.REGRESSION;
import static by.onliner.core.utils.EqualsUtil.equalContains;

@Feature("Catalog")
public class CatalogTests extends AbstractTest {

    @TestType(value = {SMOKE, REGRESSION})
    @Test(description = "[Test-Case ID:ONL_004] Test for finding item by searcher")
    public void findItemBySearcher() {
        mainPage.openPage();

        mainPage.getMenu().inputTextInSearchField(IPHONE);
        String itemName = mainPage.getMenu().getNameOfSearchedItem();

        Assert.assertTrue(equalContains(itemName, IPHONE), String.format("Searched item name [%s] wasn't contain [%s]",
                        itemName, IPHONE));
    }
}
