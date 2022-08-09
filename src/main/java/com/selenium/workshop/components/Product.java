package com.selenium.workshop.components;
import static com.selenium.workshop.utils.Parser.parseInteger;

import org.openqa.selenium.WebElement;

public abstract class Product {

    protected abstract WebElement getNameEl();
    protected abstract WebElement getPriceEl();

    public String getName() {
        return getNameEl().getText();
    }

    public int getPrice() {
        return parseInteger(getPriceEl().getText());
    }
}
