package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddToCartPage;
import pages.RegisterUserPage;

import java.time.Duration;

public class AddToCartTest {

    WebDriver driver;
    String URL = "https://automationexercise.com";
    RegisterUserPage registerPage;
    AddToCartPage addToCartPage;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    ////////////Test Case 12: Add Products in Cart\\\\\\\\\\\\\\
    @Test
    public void addToCart() {
        addToCartPage = new AddToCartPage(driver);
        registerPage=new RegisterUserPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC12");
        addToCartPage.clickProductButton();
        addToCartPage.hoverOverFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.clickAddFirstProductToCardButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.clickContinueShoppingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.hoverOverSecondProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.clickAddSecondProductToCardButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.clickViewCartButton();
        softAssert.assertTrue(addToCartPage.getFirstProductName().contains("Blue Top"));
        System.out.println("passes || TC12");
        softAssert.assertTrue(addToCartPage.getSecondProductName().contains("Men Tshirt"));
        System.out.println("passes || TC12");
        /////////////Verify prices, quantity and total price for First Element\\\\\\\\\\\\\\\\
        softAssert.assertTrue(addToCartPage.verifyPriceForFirstElement().contains("Rs. 500"));
        System.out.println("passes || TC12");
        softAssert.assertTrue(addToCartPage.verifyQuantityForFirstElement().contains("1"));
        System.out.println("passes || TC12");
        softAssert.assertTrue(addToCartPage.verifyTotalPriceForFirstElement().contains("Rs. 500"));
        /////////////Verify prices, quantity and total price for Second Element\\\\\\\\\\\\\\\\
        softAssert.assertTrue(addToCartPage.verifyPriceForSecondElement().contains("Rs. 400"));
        System.out.println("passes || TC12");
        softAssert.assertTrue(addToCartPage.verifyQuantityForSecondElement().contains("1"));
        System.out.println("passes || TC12");
        softAssert.assertTrue(addToCartPage.verifyTotalPriceForSecondElement().contains("Rs. 400"));
        System.out.println("passes || TC12");
        softAssert.assertAll();
    }
    @AfterClass
    public void exit ()
    {
        driver.quit();
    }

}
