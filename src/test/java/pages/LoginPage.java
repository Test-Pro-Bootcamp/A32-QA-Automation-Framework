package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By emailFieldLocator = By.cssSelector("[type='email']");
    private final By passwordFieldLocator= By.cssSelector("[type='password']");
    private final By submitButtonLocator = By.cssSelector("button[type='submit']");
    public void enterEmail(String email) {
        click(emailFieldLocator);
        sendKeys(emailFieldLocator,email);
    }
    public void enterPassword(String password) {
        click(passwordFieldLocator);
        sendKeys(passwordFieldLocator,password);
    }
    public void loginSubmit() {
        click(submitButtonLocator);
    }
}
