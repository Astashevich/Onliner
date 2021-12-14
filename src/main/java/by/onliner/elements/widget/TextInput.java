package by.onliner.elements.widget;

import by.onliner.elements.base.Element;
import by.onliner.elements.base.ImplementedBy;

@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {

    void click();

    void sendKeys(String keysToSend);

    @Override
    void clear();
}
