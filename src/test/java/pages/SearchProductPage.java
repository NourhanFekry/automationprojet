package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {
    WebDriver driver;
    By allProductsLabel = By.xpath("//h2[@class='title text-center']");
    By searchInput = By.id("search_product");
    By searchSummitButton = By.id("submit_search");
    By searchedProduct = By.xpath("//div[@class='features_items']//h2[@class='title text-center']");

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public String checkAllProductsLabelIsVisible()
    {
        return driver.findElement(allProductsLabel).getText();
    }
    public void putSearchInput(String productName)
    {
        driver.findElement(searchInput).sendKeys(productName);
    }
    public void clickSearchButton()
    {
        driver.findElement(searchSummitButton).click();
    }
    public String checkSearchedProductLabelIsVisible()
    {
        return driver.findElement(searchedProduct).getText();
    }
}

