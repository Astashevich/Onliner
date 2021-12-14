package elements.widget;

import elements.base.Element;
import elements.base.ImplementedBy;

@ImplementedBy(LinkImpl.class)
public interface Link extends Element {

    void click();
}
