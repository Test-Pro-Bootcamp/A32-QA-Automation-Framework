package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePrefPage extends BasePage {
    By updateProfileForm = By.cssSelector("[data-testid='update-profile-form'']");
    public ProfilePrefPage (WebDriver givenDriver)
    {super(givenDriver);
    }
    public WebElement getupdateProfilePref (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfileForm));
    }

}
