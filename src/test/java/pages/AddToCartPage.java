package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class AddToCartPage {

    WebDriver driver;
    Actions action;
    By productsButton = By.xpath("(//li)[2]");
    By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
    By addFirstProductToCartButton = By.xpath("(//div[@class='overlay-content']//a[@data-product-id='1'])");
    By continueShoppingButton = By.xpath("//button[@data-dismiss='modal']");
    By secondProduct = By.xpath("(//div[@class='productinfo text-center'])[2]");
    By addSecondProductToCardButton = By.xpath("(//div[@class='overlay-content']//a[@data-product-id='2'])");
    By viewCartButton = By.xpath("(//p)[2]");
    By firstProductName = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");
    By secondProductName = By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a");
    ////////////////// Locators for Verify prices, quantity and total price\\\\\\\\\\\\\
    By priceForBlueTop = By.xpath("(//td[@class='cart_price']//p)[1]");
    By quantityForBlueTop = By.xpath("(//td[@class='cart_quantity']//button[@class='disabled'])[1]");
    By totalPriceForBlueTop = By.xpath("(//p[@class='cart_total_price'])[1]");
    By priceForMenTShirt = By.xpath("(//td[@class='cart_price']//p)[2]");
    By quantityForMenTShirt = By.xpath("(//td[@class='cart_quantity']//button[@class='disabled'])[2]");
    By totalPriceForMenTShirt = By.xpath("(//p[@class='cart_total_price'])[2]");
    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickProductButton ()
    {
        driver.findElement(productsButton).click();
    }
    public void hoverOverFirstProduct()
    {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(firstProduct)).perform();
    }
    public void clickAddFirstProductToCardButton ()
    {
        driver.findElement(addFirstProductToCartButton).click();
    }
    public void clickContinueShoppingButton()
    {
        driver.findElement(continueShoppingButton).click();
    }
    public void hoverOverSecondProduct()
    {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(secondProduct)).perform();
    }
    public void clickAddSecondProductToCardButton()
    {
        driver.findElement(addSecondProductToCardButton).click();
    }
    public void clickViewCartButton ()
    {
        driver.findElement(viewCartButton).click();
    }
    public String getFirstProductName()
    {
        return driver.findElement(firstProductName).getText();
    }
    public String getSecondProductName()
    {
        return driver.findElement(secondProductName).getText();
    }
    public String verifyPriceForFirstElement()
    {
        return driver.findElement(priceForBlueTop).getText();
    }
    public String verifyQuantityForFirstElement()
    {
        return driver.findElement(quantityForBlueTop).getText();
    }
    public String verifyTotalPriceForFirstElement()
    {
        return driver.findElement(totalPriceForBlueTop).getText();
    }
    public String verifyPriceForSecondElement()
    {
        return driver.findElement(priceForMenTShirt).getText();
    }
    public String verifyQuantityForSecondElement()
    {
        return driver.findElement(quantityForMenTShirt).getText();
    }
    public String verifyTotalPriceForSecondElement()
    {
        return driver.findElement(totalPriceForMenTShirt).getText();
    }


}
