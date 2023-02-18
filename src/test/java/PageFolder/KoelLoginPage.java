package PageFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoelLoginPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitBtn;

    public KoelLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSumbit() {
        submitBtn.click();
    }
}
