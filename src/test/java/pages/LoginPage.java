package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']" )
    WebElement submitButtonLocator;


    public LoginPage(WebDriver setDriver) {
        super(setDriver);
    }

    public LoginPage enterEmail(String email) {
        emailFieldLocator.click();
        emailFieldLocator.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password) {
        passwordFieldLocator.click();
        passwordFieldLocator.sendKeys(password);
        return this;
    }
    public LoginPage loginSubmit() {
        submitButtonLocator.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return this;
    }
}
