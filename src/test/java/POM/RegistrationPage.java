package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    @FindBy(css="[value='Register']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getRegistrationPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }
}
