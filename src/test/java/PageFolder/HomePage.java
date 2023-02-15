package PageFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.spec.KeySpec;

public class HomePage extends BasePage {

    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By Playlistone = By.cssSelector(".playlist:nth-child(3)");
    private By playlistInputField = By.cssSelector("input[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void doubleClickFirstPlaylist() {
        doubleClick(wait.until(ExpectedConditions.elementToBeClickable(Playlistone)));
    }
    public void enterPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(playlistName);
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(Keys.ENTER);
    }
}
