package elements.widget;

import elements.base.Element;
import elements.base.ImplementedBy;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

    void click();

    boolean isClickable();
}
