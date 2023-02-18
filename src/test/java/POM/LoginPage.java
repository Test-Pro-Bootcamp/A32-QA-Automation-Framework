package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By registrationSubmitButton = By.cssSelector("[id='hel']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getLoginPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator));
    }

    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmailEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public void registrationNavigate() {
        WebElement registrationSubmit = driver.findElement(registrationSubmitButton);
        registrationSubmit.click();

        WebElement register = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(register.isDisplayed());

    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }
}
