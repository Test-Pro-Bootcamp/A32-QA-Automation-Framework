package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[id='hel']")
    private WebElement registrationSubmitButton;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getLoginPage() {
        return wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
    }

    public void clickSubmitBtn() {
        submitButtonLocator.click();
    }

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void registrationNavigate() {
        registrationSubmitButton.click();
        WebElement register = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(register.isDisplayed());

    }

    public void login() {
        provideEmail("dashazhyrkova@gmail.com");
        providePassword("te$t$tudent28");
        clickSubmitBtn();
       // Assert.assertTrue(getUserAvatar().isDisplayed);
    }
}

