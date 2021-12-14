package by.onliner.elements.widget;

import by.onliner.elements.base.Element;
import by.onliner.elements.base.ImplementedBy;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

    void click();
}
