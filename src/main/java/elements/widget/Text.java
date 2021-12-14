package elements.widget;

import elements.base.Element;
import elements.base.ImplementedBy;

@ImplementedBy(TextImpl.class)
public interface Text extends Element {

    String getText();
}
