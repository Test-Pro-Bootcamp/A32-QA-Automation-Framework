package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[data-testid='theme-card-violet'] .name")
    private WebElement themeColorVioletActive;

    @FindBy(css = "[data-testid='theme-card-violet']")
    private WebElement themColorViolet;

    @FindBy(css = "#inputProfileName")
    private WebElement inputProfileName;

    @FindBy(css = "#inputProfileCurrentPassword")
    private WebElement inputCurrentPassword;

    @FindBy(css = ".btn-submit")
    private WebElement saveButton;

    public ProfilePage chooseColorTheme() {
        themColorViolet.click();
        return this;
    }

    public boolean selectColorActive() {
        return wait.until(ExpectedConditions.visibilityOf(themeColorVioletActive)).isDisplayed();
    }

    public ProfilePage clickInputProfileName() {
        inputProfileName.click();
        return this;
    }

    public ProfilePage enterNewProfileName(String songName) {
        inputProfileName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        inputProfileName.sendKeys(songName);
        inputProfileName.sendKeys(Keys.ENTER);
        return this;
    }

    public ProfilePage clickInputCurrentPassword() {
        inputCurrentPassword.click();
        return this;
    }

    public ProfilePage inputCurrentPassword(String password) {
        inputCurrentPassword.sendKeys(password);
        return this;
    }

    public ProfilePage clickSave() {
        saveButton.click();
        return this;
    }
}
