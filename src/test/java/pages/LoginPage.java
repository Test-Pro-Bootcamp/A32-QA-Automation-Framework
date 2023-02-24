package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage extends BasePage {
    private @FindBy(css = "[type='email']")
    WebElement emailFieldLocator;
    private @FindBy(css = "[type='password']")
    WebElement passwordFieldLocator;
    private @FindBy(css = "button[type='submit']" )
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
        HomePage homePage = new HomePage(driver);
        submitButtonLocator.click();
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.getPlaylist()));
        return this;
    }
    public WebElement getButton(){ return submitButtonLocator;

    }
}
