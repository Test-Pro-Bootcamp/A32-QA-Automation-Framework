package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By emailFieldLocator = By.cssSelector("[type='email']");
    private final By passwordFieldLocator= By.cssSelector("[type='password']");
    private final By submitButtonLocator = By.cssSelector("button[type='submit']");
    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.click();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    public void loginSubmit() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        button.click();

    }
}
