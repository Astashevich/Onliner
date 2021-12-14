package by.onliner.elements.widget;

import by.onliner.elements.base.Element;
import by.onliner.elements.base.ImplementedBy;

@ImplementedBy(LinkImpl.class)
public interface Link extends Element {

    void click();
}
