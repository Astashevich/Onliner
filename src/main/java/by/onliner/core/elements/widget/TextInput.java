package by.onliner.core.elements.widget;

import by.onliner.core.elements.base.Element;
import by.onliner.core.elements.base.ImplementedBy;

@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {

    void click();

    void sendKeys(String keysToSend);

    @Override
    void clear();
}
