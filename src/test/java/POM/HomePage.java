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
    @FindBy(css="img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(xpath="//a[@href='#!/songs']")
    private WebElement allSongsLocator;
    @FindBy(css=".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(xpath="//input[@name='name']")
    private WebElement playlistInputField;
    @FindBy(css="[data-testid='inline-playlist-name-input'")
    private WebElement renamePlaylistInput;
    @FindBy(xpath="//a[text()='My new playlist']")
    private WebElement myNewPlaylistVerify;
    @FindBy(css="[data-testid='sidebar-create-playlist-btn']")
    private WebElement createPlaylistButton;
    @FindBy(css="[alt='Sound bars']")
    private WebElement soundBarLocator;
    @FindBy(css="[data-testid='playlist-context-menu-create-simple']")
    private WebElement selectSimplePlaylist;
    @FindBy(xpath="//a[text()='My playlist']")
    private WebElement myNewPlaylistName;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUsrAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void doubleClickFirstPlaylist() {
        doubleclick(driver.findElement(firstPlaylist));
    }

    public void navigateToAllSongs() {
        WebElement navigateToAllSongsPage = wait.until(ExpectedConditions
                .elementToBeClickable(allSongsLocator));
        navigateToAllSongsPage.click();
    }

    public void playlistDoubleClick() {
        Actions actn = new Actions(driver);
        wait.until(ExpectedConditions
                .elementToBeClickable(firstPlaylist));
        WebElement playlistDblClick = driver.findElement(firstPlaylist);
        actn.doubleClick(playlistDblClick).perform();
    }

    public void renamePlaylistName() {
        WebElement playlistRenameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(renamePlaylistInput));
        playlistRenameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistRenameInput.sendKeys("My new playlist");
        playlistRenameInput.sendKeys(Keys.ENTER);
    }

    public void verifyPlaylistRenamed() {
        WebElement myNewPlaylist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(myNewPlaylistVerify));
        Assert.assertTrue(myNewPlaylist.isDisplayed());
    }

    public void songIsPlaying() {
        WebElement songPlaying = wait.until(ExpectedConditions
                .presenceOfElementLocated(soundBarLocator));
        Assert.assertTrue(songPlaying.isDisplayed());
    }

    public void createNewPlaylist() {
        WebElement createPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(createPlaylistButton));
        createPlaylist.click();
    }

    public void selectNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(selectSimplePlaylist));
        newPlaylist.click();
    }

    public void enterPlaylistName() {
        WebElement playlistInput = wait.until(ExpectedConditions
                .elementToBeClickable(playlistInputField));
        playlistInput.sendKeys("My playlist");
        playlistInput.sendKeys(Keys.ENTER);
    }

    public void verifyPlaylistCreated() {
        WebElement playlistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(myNewPlaylistName));
        Assert.assertTrue(playlistName.isDisplayed());
    }
}
