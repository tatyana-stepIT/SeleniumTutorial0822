package com.selenium.workshop.pages;

import com.selenium.workshop.components.CatalogProduct;
import com.selenium.workshop.components.SearchComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.List;

import static com.selenium.workshop.utils.Waiter.waitUntilPresent;

public class CatalogPage extends LoadableComponent<CatalogPage> {

    @FindBy(css = ".product-grid > div")
    private List<WebElement> catalogProductElements;

    private final By results = By.className("results");
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<CatalogProduct> getProductList() {
        List<CatalogProduct> catalogProducts = new ArrayList<>();
        for (WebElement productEl : catalogProductElements) {
            catalogProducts.add(new CatalogProduct(productEl));
        }
        return catalogProducts;
    }

    public void openItem(int productIndex) {
        catalogProductElements.get(productIndex).click();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilPresent(driver, results);
    }
}
