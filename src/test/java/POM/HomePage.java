package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsLocator = By.xpath("//a[@href='#!/songs']");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.xpath("//input[@name='name']");
    By renamePlaylistInput = By.cssSelector("[data-testid='inline-playlist-name-input'");
    By myNewPlaylistVerify = By.xpath("//a[text()='My new playlist']");
    By createPlaylistButton = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By soundBarLocator = By.cssSelector("[alt='Sound bars']");
    By selectSimplePlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By myNewPlaylistName = By.xpath("//a[text()='My playlist']");

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
