package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    private WebElement emailFieldLocator;
    @FindBy(css = "[type='password']")
    private WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css = "input[value='Register']")
    private WebElement registerButtonLocator;
    @FindBy(css = "#hel")
    private WebElement registrationFieldLocator;
    String email = "vlina7078@yahoo.com";
    String password = "te$t$tudent";

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email) {
        emailFieldLocator.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordFieldLocator.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButtonLocator.click();
    }

    public void login() {
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
    }

}
