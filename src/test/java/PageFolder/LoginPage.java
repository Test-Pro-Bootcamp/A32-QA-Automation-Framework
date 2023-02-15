package PageFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By registrationLink = By.cssSelector("a#hel");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator)).click();}

    public void provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);}
    public void providePassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);}

    public void provideLoginSucceed() {
        provideEmail("demotesting@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
