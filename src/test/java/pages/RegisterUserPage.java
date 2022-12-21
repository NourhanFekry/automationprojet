package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserPage
{
    WebDriver driver;
    WebDriverWait driverWait;
    Select drpDate;
    Select drpMonth;
    Select dropYear;
    Select drpCountry;
    By homePage = By.xpath("(//li)[1]");
    By signUpLoginButton = By.xpath("//*[@href='/login']");
    By nameFiled = By.xpath("//*[@data-qa='signup-name']");
    By emailFiled = By.xpath("//*[@data-qa='signup-email']");
    By newUserSignUpLabel = By.xpath("//div[@class='signup-form']//h2");
    By signUpButton = By.xpath("//*[@data-qa='signup-button']");
    ///////////////////// locators for registerPage\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    By enterAccountInformationLabel = By.xpath( "(//div[@class='login-form']//h2)[1]");
    By mrsRadioButton = By.id("id_gender2");
    By passwordInRegisterPage = By.id("password");
    By dayOfBirth = By.id("days");
    By monthOfBirth = By.id("months");
    By yearOfBirth = By.id("years");
    By SignUpForNewsletterCheckbox = By.id("newsletter");
    By ReceiveSpecialOffersCheckbox = By.id("optin");
    /////////////////////////locators for Address Information\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    By firstNameEdittext = By.id("first_name");
    By lastNameEdittext = By.id("last_name");
    By companyEdittext = By.id("company");
    By addressEdittext = By.id("address1");
    By address2Edittext = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipCode = By.id ("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton = By.xpath("//*[@data-qa='create-account']");
    /////////////// locators for created account  \\\\\\\\\\\\\\\\\\\\\\\\\\
    By createdAccountSuccessfully = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By continueButton = By.xpath("//*[@data-qa='continue-button']");
    By loggedInAsUserName = By.xpath(" //i[contains(@class,'fa-user')]//parent::a");
    /////////////// locators for delete account  \\\\\\\\\\\\\\\\\\\\\\\\\\
    By deleteAccountButton = By.xpath("(//li)[5]");
    By deleteAccountSuccessfully = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    /////////////////locators for logout\\\\\\\\\\\\\\\\\\\\\\\\\\\
    By logoutButton = By.xpath("(//li)[4]");
    By emailAlreadyExistLabel = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

    public RegisterUserPage(WebDriver driver)
    {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public String checkPageHomeIsVisible()
    {
        return driver.findElement(homePage).getText();
    }
    public void signUpLoginButtonClick()
    {
        driverWait.until(ExpectedConditions.elementToBeClickable(signUpLoginButton));
        driver.findElement(signUpLoginButton).click();
    }
    public String signUpButtonIsVisible()
    {
       return driver.findElement(newUserSignUpLabel).getText();
    }
    public void enterName(String name)
    {
        driver.findElement(nameFiled).sendKeys(name);
    }
    public void enterEmail(String email)
    {
        driver.findElement(emailFiled).sendKeys(email);
    }
    public void clickSignUpButton()
    {
        driver.findElement(signUpButton).click();
       // driverWait.until(ExpectedConditions.elementToBeClickable(signUpButton));
    }
    public String accountInformationLabel()
    {
        return driver.findElement(enterAccountInformationLabel).getText();
    }
    public void clickRadioButton()
    {
        driver.findElement(mrsRadioButton).click();
    }
    public void fillPasswordInRegisterPage (String password)
    {
        driver.findElement(passwordInRegisterPage).sendKeys(password);
    }
    public void setDateOfBirth(String day,String month,String year)
    {
        drpDate = new Select(driver.findElement(dayOfBirth));
        drpDate.selectByVisibleText(day);
        drpMonth = new Select(driver.findElement(monthOfBirth));
        drpMonth.selectByVisibleText(month);
        dropYear = new Select(driver.findElement(yearOfBirth)) ;
        dropYear.selectByVisibleText(year);
    }
    public void checkSignUpCheckbox()
    {
        driver.findElement(SignUpForNewsletterCheckbox).click();
    }
    public void checkReceiveSpecialOffersCheck()
    {
        driver.findElement(ReceiveSpecialOffersCheckbox).click();
    }
    public void fillFullName(String firstName, String lastName)
    {
        driver.findElement(firstNameEdittext).sendKeys(firstName);
        driver.findElement(lastNameEdittext).sendKeys(lastName);
    }
   public void fillCompanyName (String companyName)
    {
        driver.findElement(companyEdittext).sendKeys(companyName);
    }
   public void fillFullyCompanyAddress(String addressOne,String addressTwo)
   {
       driver.findElement(addressEdittext).sendKeys(addressOne);
       driver.findElement(address2Edittext).sendKeys(addressTwo);
   }
    public void selectCountry (String countryName)
    {
        drpCountry = new Select(driver.findElement(country));
        drpCountry.selectByVisibleText(countryName);
    }
    public void fillAddressData(String stateName, String cityName)
    {
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(city).sendKeys(cityName);
    }
    public void fillZipCode(String zipCodeValue)
    {
        driver.findElement(zipCode).sendKeys(zipCodeValue);
    }
    public void fillMobilePhone(String phoneNumber)
    {
        driver.findElement(mobileNumber).sendKeys(phoneNumber);
    }
    public void clickCreateAccountButton()
    {
        driverWait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        driver.findElement(createAccountButton).click();
    }
   public void checkCreatedSuccessfully()
   {
       driver.findElement(createdAccountSuccessfully).getText();
   }
   public void clickContinue ()
   {
       driver.findElement(continueButton).click();
   }
   public String checkLoggedInAsUserIsVisible()
   {
      return driver.findElement(loggedInAsUserName).getText();
   }
   public void clickDeleteAccountButton()
   {
       driver.findElement(deleteAccountButton).click();
   }
   public String  checkDeleteAccountSuccessfully()
   {
      return driver.findElement(deleteAccountSuccessfully).getText();
   }
   public void logout ()
   {
       driver.findElement(logoutButton).click();
       driverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
   }
    public String checkEmailAlreadyExist()
    {
        return driver.findElement(emailAlreadyExistLabel).getText();
    }
}
