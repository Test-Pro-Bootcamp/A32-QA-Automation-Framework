package PageFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoelLoginPage {
    private WebDriver driver;
    @FindBy(css="[type='email']")
    private WebElement emailField;
    @FindBy(css="[type='password']")
    private WebElement passwordField;
    @FindBy(css="button[type='submit']")
    private WebElement submitBtn;

    public KoelLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmitbtn() {
        submitBtn.click();
    }
}
