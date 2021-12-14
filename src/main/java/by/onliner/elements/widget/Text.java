package by.onliner.elements.widget;

import by.onliner.elements.base.Element;
import by.onliner.elements.base.ImplementedBy;

@ImplementedBy(TextImpl.class)
public interface Text extends Element {

    String getText();
}
