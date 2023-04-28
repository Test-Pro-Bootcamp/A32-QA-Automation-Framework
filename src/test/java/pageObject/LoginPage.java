package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;
public class LoginPage extends BasePage {
    @FindBy(css ="[type='email']")
    private WebElement emailFieldLocator;
    @FindBy(css = "[type='password']")
    private WebElement passwordFieldLocator;
    @FindBy(css = "[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLoginLocator;
    @FindBy(id = "a#hel")
    private WebElement registrationLinkLocator;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage provideEmail(String email) {
        emailFieldLocator.click();
        emailFieldLocator.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordFieldLocator.click();
        passwordFieldLocator.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }
    public LoginPage login(){
        provideEmail("burkovads@mail.ru");
        providePassword("julka@0721");
        clickSubmitBtn();
        return this;
    }
    public WebElement submitLoginButton() {
        return submitButtonLoginLocator;
    }
    public WebElement registrationLink() {
        return registrationLinkLocator;
    }
}
