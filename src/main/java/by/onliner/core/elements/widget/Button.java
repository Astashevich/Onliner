package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.Element;
import by.onliner.core.elements.base.ImplementedBy;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

    void click();
}
