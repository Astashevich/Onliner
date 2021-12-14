package elements.widget;

import elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Link functionalities
 */
public class LinkImpl extends ElementImpl implements Link {

    /**
     * Creates a Element for a given WebElement.
     * @param element element to wrap up
     */
    public LinkImpl(WebElement element) {
        super(element);
    }

    public void click() {
        getWrappedElement().click();
    }
}
