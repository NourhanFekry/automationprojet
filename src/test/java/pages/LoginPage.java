package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage
{
    WebDriver driver;
    By loginToYourAccount = By.xpath("//div[@class='login-form']//h2");
    By loginEmailFiled = By.xpath("//*[@data-qa='login-email']");
    By loginPasswordFiled = By.xpath("//*[@data-qa='login-password']");
    By loginButton = By.xpath("//*[@data-qa='login-button']");
    By incorrectLoginData = By.xpath("(//P)[1]");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public String checkLoginToYourAccountIsVisible()
    {
        return driver.findElement(loginToYourAccount).getText();
    }
    public void enterDataInLoginEmailFiled(String emailValue,String passwordValue)
    {
        driver.findElement(loginEmailFiled).sendKeys(emailValue);
        driver.findElement(loginPasswordFiled).sendKeys(passwordValue);
    }
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
    public String checkIncorrectLoginData()
    {
        return driver.findElement(incorrectLoginData).getText();
    }
}

