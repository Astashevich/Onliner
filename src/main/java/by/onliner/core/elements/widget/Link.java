package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.Element;
import by.onliner.core.elements.base.ImplementedBy;

@ImplementedBy(LinkImpl.class)
public interface Link extends Element {

    void click();
}
