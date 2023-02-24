package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(xpath = "//a[@href='#!/songs']")
    private WebElement allSongsLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement playlistInputField;
    @FindBy(css = "[data-testid='inline-playlist-name-input'")
    private WebElement renamePlaylistInput;
    @FindBy(xpath = "//a[text()='My new playlist']")
    private WebElement myNewPlaylistVerify;
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    private WebElement createPlaylistButton;
    @FindBy(css = "[alt='Sound bars']")
    private WebElement soundBarLocator;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement selectSimplePlaylist;
    @FindBy(xpath = "//a[text()='My playlist']")
    private WebElement myNewPlaylistName;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUsrAvatar() {
        return wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }

    public void doubleClickFirstPlaylist() {
        doubleclick(firstPlaylist);
    }

    public void navigateToAllSongs() {

        allSongsLocator.click();
    }

    public void playlistDoubleClick() {
        Actions actn = new Actions(driver);
        actn.doubleClick(firstPlaylist).perform();
    }

    public void renamePlaylistName() {
        renamePlaylistInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        renamePlaylistInput.sendKeys("My new playlist");
        renamePlaylistInput.sendKeys(Keys.ENTER);
    }

    public void verifyPlaylistRenamed() {
        Assert.assertTrue(myNewPlaylistVerify.isDisplayed());
    }

    public void songIsPlaying() {
        WebElement songPlaying = wait.until(ExpectedConditions
                .visibilityOf(soundBarLocator));
        Assert.assertTrue(songPlaying.isDisplayed());
    }

    public void createNewPlaylist() {
        createPlaylistButton.click();
    }

    public void selectNewPlaylist() {
        selectSimplePlaylist.click();
    }

    public void enterPlaylistName() {
        playlistInputField.sendKeys("My playlist");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void verifyPlaylistCreated() {
        WebElement playlistName = wait.until(ExpectedConditions
                .visibilityOf(myNewPlaylistName));
        Assert.assertTrue(playlistName.isDisplayed());
    }
}
