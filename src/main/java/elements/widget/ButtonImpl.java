package elements.widget;

import elements.base.ElementImpl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Waiter;

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

    /***
     * Checks the button clickable on a page
     * @return boolean true for a clickable Button, or false if passed a Element Not Interactable Exception.
     */
    @Override
    public boolean isClickable() {
        try {
            Waiter.elementToBeClickable(getWrappedElement());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
