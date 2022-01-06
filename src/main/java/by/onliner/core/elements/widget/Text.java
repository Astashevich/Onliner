package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.Element;
import by.onliner.core.elements.base.ImplementedBy;

@ImplementedBy(TextImpl.class)
public interface Text extends Element {

    String getText();
}
