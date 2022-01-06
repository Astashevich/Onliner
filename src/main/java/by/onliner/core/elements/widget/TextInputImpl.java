package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Entry field functionalities
 */
public class TextInputImpl extends ElementImpl implements TextInput {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextInputImpl(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }

    @Override
    public void sendKeys(String keysToSend) {
        getWrappedElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }
}
