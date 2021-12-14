package elements.widget;

import elements.base.Element;
import elements.base.ImplementedBy;

@ImplementedBy(EntryFieldImpl.class)
public interface EntryField extends Element {

    void click();

    void sendKeys(String keysToSend);

    @Override
    void clear();
}
