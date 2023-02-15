package pageObject;
import org.openqa.selenium.By;
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
    @FindBy(css = ".view-profile")
    private WebElement profileLocator;
    @FindBy(css = ".view-profile .name")
    private WebElement userNameField;
    @FindBy(css = "[name='name']")
    private WebElement nameInputField;
    @FindBy(css = "#inputProfileCurrentPassword")
    private WebElement passwordInputField;
    @FindBy(css = ".btn-submit")
    private WebElement saveButtonLocator;
    @FindBy(id = "hel")
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
    public LoginPage login(String email, String password){
        emailFieldLocator.click();
        emailFieldLocator.sendKeys(email);
        passwordFieldLocator.click();
        passwordFieldLocator.sendKeys(password);
        submitButtonLocator.click();
        return this;
    }
    public LoginPage openUserProfile() {
        profileLocator.click();
        return this;
    }
    public String getUsername() {
        return userNameField.getText();
    }
    public LoginPage setName(String newName) {
        nameInputField.click();
        nameInputField.clear();
        nameInputField.sendKeys(newName);
        return this;
    }
    public LoginPage setPassword(String password) {
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }
    public LoginPage saveProfile() {
        saveButtonLocator.click();
        return this;
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }
    public WebElement submitLoginButton() {
        return submitButtonLoginLocator;
    }
    public WebElement registrationLink() {
        return registrationLinkLocator;
    }
}
