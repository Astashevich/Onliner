package elements.widget;

import elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Entry field functionalities
 */
public class EntryFieldImpl extends ElementImpl implements EntryField {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public EntryFieldImpl(WebElement element) {
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
