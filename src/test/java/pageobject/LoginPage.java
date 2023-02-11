package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By submitButtonLoginLocator = By.cssSelector("button[type='submit']");
    By successBanerLocator = By.cssSelector(".success");
    By profileLocator = By.cssSelector(".view-profile");
    By userNameField = By.cssSelector(".view-profile .name");
    By nameInputField = By.cssSelector("#inputProfileName");
    By passwordInputField = By.cssSelector("#inputProfileCurrentPassword");
    By saveButtonLocator = By.cssSelector(".btn-submit");
    By registrationLinkLocator = By.id("hel");
    public LoginPage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    public WebElement getSuccessBanner() {
        return driver.findElement(successBanerLocator);
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
        WebElement submitLoginButton = driver.findElement(submitButtonLoginLocator);
        return submitLoginButton;
    }
    public WebElement registrationLink() {
        WebElement registrationLink = driver.findElement(registrationLinkLocator);
        return registrationLink;
    }
}
