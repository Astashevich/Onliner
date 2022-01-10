package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Button functionalities
 */
public class ButtonImpl extends ElementImpl implements Button {

    /**
     * Creates a Element for a given WebElement.
     * @param element element to wrap up
     */
    public ButtonImpl(WebElement element) {
        super(element);
    }

    public void click() {
        getWrappedElement().click();
    }
}
