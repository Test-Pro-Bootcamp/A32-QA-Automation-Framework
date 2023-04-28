package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {
    @FindBy(css = "[name='name']")
    private WebElement nameInputField;
    @FindBy(css = "#inputProfileCurrentPassword")
    private WebElement passwordInputField;
    @FindBy(css = ".btn-submit")
    private WebElement saveButtonLocator;
    @FindBy(css = ".view-profile .name")
    private WebElement userNameField;
    @FindBy(css = ".theme")
    private WebElement themeColor;
    @FindBy(css = ".theme.selected")
    private WebElement selectedThemeColor;
    @FindBy(css = "input[name='notify']")
    private WebElement checkboxNotify;
    @FindBy(css = "input[name='notify']:checked")
    private WebElement selectedCheckboxNotify;
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public ProfilePage setName(String newName) {
        nameInputField.click();
        nameInputField.clear();
        nameInputField.sendKeys(newName);
        return this;
    }
    public ProfilePage setPassword(String password) {
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }
    public ProfilePage saveProfile() {
        saveButtonLocator.click();
        return this;
    }
    public String getUsername() {
        return userNameField.getText();
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public ProfilePage chooseTheme() {
        themeColor.click();
        return this;
    }
    public boolean checkSelectedThemeColor() {
        return wait.until(ExpectedConditions.visibilityOf(selectedThemeColor)).isDisplayed();
    }
    public ProfilePage selectCheckboxNotify() {
        checkboxNotify.click();
        return this;
    }
    public boolean checkSelectedCheckboxNotify() {
        return wait.until(ExpectedConditions.visibilityOf(selectedCheckboxNotify)).isDisplayed();
    }
}

