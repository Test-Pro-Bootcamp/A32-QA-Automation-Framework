package PageFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    By submitButton = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void SubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();}

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);}
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);}

    public void provideLoginSucceed() {
        enterEmail("demotesting@gmail.com");
        enterPassword("te$t$tudent");
        SubmitBtn();
    }
}
