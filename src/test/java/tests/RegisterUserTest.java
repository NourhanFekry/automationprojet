package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.RegisterUserPage;

import java.time.Duration;

public class RegisterUserTest
{
    WebDriver driver;
    RegisterUserPage registerPage;
    String URL = "https://automationexercise.com/";
    LoginPage loginPage;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(URL);
        registerPage = new RegisterUserPage(driver);
    }
    /////////////////Test Case 1: Register User\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void fillDataInRegisterPage()
    {
        registerPage=new RegisterUserPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC1");
        registerPage.signUpLoginButtonClick();
        softAssert.assertEquals(registerPage.signUpButtonIsVisible(),"New User Signup!","Text not Matched");
        System.out.println("passes || TC1");
        registerPage.enterName("NOUR");
        registerPage.enterEmail("nourfekrym@gmail.com");
        registerPage.clickSignUpButton();
        softAssert.assertEquals(registerPage.accountInformationLabel(),"ENTER ACCOUNT INFORMATION","Text not Matched");
        System.out.println("passes || TC1");
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
        registerPage.checkCreatedSuccessfully();
        registerPage.clickContinue();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        softAssert.assertTrue(registerPage.checkLoggedInAsUserIsVisible().contains("Logged in as "+ "NOUR"));
        System.out.println("passes || TC1");
        registerPage.clickDeleteAccountButton();
        softAssert.assertEquals(registerPage.checkDeleteAccountSuccessfully(),"ACCOUNT DELETED!");
        System.out.println("passes || TC1");
        softAssert.assertAll();
        registerPage.clickContinue();
    }
    /////////////////Test Case 5: Register User with existing email\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void registerWithExistingEmail()
    {
        registerPage=new RegisterUserPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC5");
        registerPage.signUpLoginButtonClick();
        softAssert.assertEquals(registerPage.signUpButtonIsVisible(),"New User Signup!","Text not Matched");
        System.out.println("passes || TC5");
        registerPage.enterName("NOUR");
        registerPage.enterEmail("NOURHANFeKRY@gmail.com");
        registerPage.clickSignUpButton();
        softAssert.assertTrue(registerPage.checkEmailAlreadyExist().contains("Email Address already exist!"));
        System.out.println("passes || TC5");
        softAssert.assertAll();
    }
    /////////////////Test Case 4: Logout User\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void logoutUser()
    {
        registerPage=new RegisterUserPage(driver);
        loginPage= new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( registerPage.checkPageHomeIsVisible(),"Home","Text not Matched");
        System.out.println("passes || TC4");
        registerPage.signUpLoginButtonClick();
        softAssert.assertTrue(loginPage.checkLoginToYourAccountIsVisible().contains("Login to your account"));
        System.out.println("passes || TC4");
        loginPage.enterDataInLoginEmailFiled("nourfekrymmE@gmail.com","23456789");
        loginPage.clickLoginButton();
        softAssert.assertTrue(registerPage.checkLoggedInAsUserIsVisible().contains("Logged in as "+ "NOUR"));
        System.out.println("passes || TC4");
        registerPage.logout();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
        System.out.println("passes || TC4");
        softAssert.assertAll();
    }
    @AfterClass
    public void exitDriver ()
    {
        driver.quit();
    }

}
