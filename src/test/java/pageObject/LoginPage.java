package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.UUID;
public class LoginPage extends BasePage {
    private final By emailField = By.cssSelector("[type='email']");
    private final By passwordField = By.cssSelector("[type='password']");
    private final By submitButtonLocator = By.cssSelector("[type='submit']");
    private final By submitButtonLoginLocator = By.cssSelector("button[type='submit']");
    private final By profileLocator = By.cssSelector(".view-profile");
    private final By userNameField = By.cssSelector(".view-profile .name");
    private final By nameInputField = By.cssSelector("[name='name']");
    private final By passwordInputField = By.cssSelector("#inputProfileCurrentPassword");
    private final By saveButtonLocator = By.cssSelector(".btn-submit");
    private final By registrationLinkLocator = By.id("hel");
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }
    public void login(String email, String password){
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
        driver.findElement(submitButtonLocator).click();
    }
    public void openUserProfile() {
        WebElement profile = driver.findElement(profileLocator);
        profile.click();
    }
    public String getUsername() {
        return driver.findElement(userNameField).getText();
    }
    public void setName(String newName) {
        WebElement nameInput = driver.findElement(nameInputField);
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(newName);
    }
    public void setPassword() {
        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent");
    }
    public void saveProfile() {
        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }
    public WebElement submitLoginButton() {
        return driver.findElement(submitButtonLoginLocator);
    }
    public WebElement registrationLink() {
        return driver.findElement(registrationLinkLocator);
    }
}
