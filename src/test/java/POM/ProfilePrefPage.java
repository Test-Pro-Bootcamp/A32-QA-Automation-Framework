package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePrefPage extends BasePage {
    @FindBy(css = "[data-testid='update-profile-form'']")
    private WebElement updateProfileForm;

    public ProfilePrefPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUpdateProfilePref() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) updateProfileForm));
    }

}
