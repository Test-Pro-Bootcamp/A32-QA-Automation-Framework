package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginPage (WebDriver givenDriver)
    {super(givenDriver);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }
    public void provideEmailEmail(String email) {
        WebElement emailElement =driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }
}
