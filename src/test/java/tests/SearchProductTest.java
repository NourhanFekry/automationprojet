package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddToCartPage;
import pages.LoginPage;
import pages.RegisterUserPage;
import pages.SearchProductPage;

public class SearchProductTest {
    WebDriver driver;
    RegisterUserPage registerPage;
    String URL = "https://automationexercise.com";
    AddToCartPage addToCartPage;
    SearchProductPage searchProductPage;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    //////////////Test Case 9: Search Product\\\\\\\\\\\\\\\
    @Test
    public void searchProduct()
    {
        registerPage=new RegisterUserPage(driver);
        addToCartPage=new AddToCartPage(driver);
        searchProductPage=new SearchProductPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC9");
        addToCartPage.clickProductButton();
        softAssert.assertTrue(searchProductPage.checkAllProductsLabelIsVisible().contains("ALL PRODUCTS"));
        System.out.println("passes || TC9");
        searchProductPage.putSearchInput("Dress");
        searchProductPage.clickSearchButton();
        softAssert.assertTrue(searchProductPage.checkSearchedProductLabelIsVisible().contains("SEARCHED PRODUCTS"));
        System.out.println("passes || TC9");
        softAssert.assertAll();
        if(driver.getPageSource().contains("Dress")){
            System.out.println("Text is present");
        }else{
            System.out.println("Text is absent");
        }
    }
    @AfterClass
    public void exit ()
    {
        driver.quit();
    }

}
