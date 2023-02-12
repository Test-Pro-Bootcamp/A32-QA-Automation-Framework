package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By emailField = By.cssSelector("[type='email']");
    static By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");
    By successBanner = By.cssSelector(".success");
    static By profile = By.cssSelector(".view-profile");
    By userName = By.cssSelector(".view-profile .name");
    By nameInput = By.cssSelector("#inputProfileName");
    By passwordInput = By.cssSelector("#inputProfileCurrentPassword");
    By saveButton = By.cssSelector(".btn-submit");
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void clickButtonSubmit(){
        driver.findElement(submitButton).click();
    }

    public void passwordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public static void openUserProfile() {
        driver.findElement(profile).click();
    }

    public WebElement getUsername() {
        driver.findElement(userName).getText();
        return driver.findElement(userName);
    }

    public WebElement getsubmitButton(){
        driver.findElement(submitButton).getText();
        return driver.findElement(submitButton);
    }
    public void setName(String newName) {
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(newName);
    }

    public void setPassword() {
       driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys("te$t$tudent");
    }

    public void saveProfile() {
        driver.findElement(saveButton).click();
    }

    public WebElement getSuccessBanner() {
        driver.findElement(successBanner).getText();
        return driver.findElement(successBanner);
    }
}