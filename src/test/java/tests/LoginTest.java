package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.RegisterUserPage;

public class LoginTest
{
    WebDriver driver;
    RegisterUserPage registerPage;
    LoginPage loginPage;
    String URL = "https://automationexercise.com";

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(URL);
        registerPage = new RegisterUserPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.signUpLoginButtonClick();
        registerPage.enterName("NOUR");
        registerPage.enterEmail("nourfekrymmE@gmail.com");
        registerPage.clickSignUpButton();
        registerPage.clickRadioButton();
        registerPage.fillPasswordInRegisterPage("23456789");
        registerPage.setDateOfBirth("28","February","2000");
        registerPage.checkSignUpCheckbox();
        registerPage.checkReceiveSpecialOffersCheck();
        registerPage.fillFullName("Nourhan","Fekry");
        registerPage.fillCompanyName("VOIS");
        registerPage.fillFullyCompanyAddress("Maadi","Smart");
        registerPage.selectCountry("Canada");
        registerPage.fillAddressData("Egypt","Egypt");
        registerPage.fillZipCode("345678");
        registerPage.fillMobilePhone("0123456789");
        registerPage.clickCreateAccountButton();
        registerPage.clickContinue();
        registerPage.logout();
    }
    /////////////////Test Case 2: Login User with correct email and password\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void loginWithCorrectData()
    {
        registerPage=new RegisterUserPage(driver);
        loginPage= new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC2");
        registerPage.signUpLoginButtonClick();
        softAssert.assertTrue(loginPage.checkLoginToYourAccountIsVisible().contains("Login to your account"));
        System.out.println("passes || TC2");
        loginPage.enterDataInLoginEmailFiled("nourfekrymmE@gmail.com","23456789");
        loginPage.clickLoginButton();
        softAssert.assertTrue(registerPage.checkLoggedInAsUserIsVisible().contains("Logged in as "+ "NOUR"));
        System.out.println("passes || TC2");
        registerPage.clickDeleteAccountButton();
        softAssert.assertEquals(registerPage.checkDeleteAccountSuccessfully(),"ACCOUNT DELETED!");
        System.out.println("passes || TC2");
        softAssert.assertAll();
    }
    /////////////////Test Case 3: Login User with incorrect email and password\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void loginWithIncorrectData()
    {
        registerPage=new RegisterUserPage(driver);
        loginPage= new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC3");
        registerPage.signUpLoginButtonClick();
        softAssert.assertTrue(loginPage.checkLoginToYourAccountIsVisible().contains("Login to your account"),"text not matched");
        System.out.println("passes || TC3");
        loginPage.enterDataInLoginEmailFiled("NOur@gmail.com","23456789");
        loginPage.clickLoginButton();
        softAssert.assertTrue(loginPage.checkIncorrectLoginData().contains("Your email or password is incorrect!"));
        System.out.println("passes || TC3");
        softAssert.assertAll();
    }


    @AfterClass
    public void closeDriver()
    {
        driver.close();
    }
}
