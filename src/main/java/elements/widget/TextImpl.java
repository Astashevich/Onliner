package elements.widget;

import elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Text functionalities
 */
public class TextImpl extends ElementImpl implements Text {

    /**
     * Creates a Element for a given WebElement.
     * @param element element to wrap up
     */
    public TextImpl(WebElement element) {
        super(element);
    }

    public String getText() {
        return getWrappedElement().getText();
    }
}
