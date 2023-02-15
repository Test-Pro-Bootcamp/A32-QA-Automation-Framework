package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    By emailFieldLocator = By.cssSelector("input[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");
    By registerButtonLocator = By.cssSelector("input[value='Register']");
    By registrationFieldLocator = By.cssSelector("#hel");
    String email = "vlina7078@yahoo.com";
    String password = "te$t$tudent";

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public By getEmailFieldLocator() {
        return emailFieldLocator;
    }

    public By getPasswordFieldLocator() {
        return passwordFieldLocator;
    }

    public By getSubmitButtonLocator() {
        return submitButtonLocator;
    }

    public By getRegisterButtonLocator() {
        return registerButtonLocator;
    }

    public By getRegistrationFieldLocator() {
        return registrationFieldLocator;
    }

    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();
    }
        public void login(){
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
    }

}
