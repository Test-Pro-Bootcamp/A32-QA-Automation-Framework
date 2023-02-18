package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    By registerButton = By.cssSelector("[value='Register']");

    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getRegistrationPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }
}
