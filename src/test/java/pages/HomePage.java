package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class HomePage extends BasePage {
    @FindBy(css = "[class='success show']" )
    private WebElement NotificationLocator;
    @FindBy(css ="[data-testid='inline-playlist-name-input']")
    private WebElement playlistFieldLocator;
    @FindBy(xpath = "//li[@class='playlist playlist']")
    private WebElement playlistLocator;
    @FindBy(css = ".avatar")
    private WebElement avatarLocator;
    @FindBy(css ="[title='Create a new playlist']")
    private WebElement createPlaylistBtnLocator;
    @FindBy(css ="[data-testid='playlist-context-menu-create-simple']" )
    private WebElement newPlaylistBtnLocator;
    @FindBy(css ="input[name='name']")
    private WebElement newPlaylistFieldLocator;
    @FindBy(css="[alt='Sound bars']")
    private WebElement soundBars;
    public HomePage(WebDriver setDriver) {
        super(setDriver);
    }
    public HomePage enterPlaylist() {
        doubleClick(playlistLocator);
        return this;
    }
    public HomePage changePlaylistName(String playlist) {
        wait.until(ExpectedConditions.visibilityOf(playlistFieldLocator));
        playlistFieldLocator.sendKeys(Keys.CONTROL + "a");
        playlistFieldLocator.sendKeys(Keys.DELETE);
        playlistFieldLocator.sendKeys(playlist, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(NotificationLocator));
        return this;
    }
    public HomePage deleteActions(){
        playlistLocator.click();
        PlaylistPage playlistPage = new PlaylistPage(driver);
        wait.until(ExpectedConditions.visibilityOf(playlistPage.getDeleteButton()));
        playlistPage.getDeleteButton().click();
        wait.until(ExpectedConditions.visibilityOf(NotificationLocator));
        return this;
    }
    public WebElement getNotification(){
        return NotificationLocator;
    }
    public WebElement getAvatar(){
        return avatarLocator;
    }
    public WebElement getPlaylist(){return playlistLocator;}
    public WebElement getSoundBars(){return soundBars;}
    public HomePage createNewPlaylist(){
        createPlaylistBtnLocator.click();
        newPlaylistBtnLocator.click();
        return this;
    }
    public HomePage setPlaylistName(String name){
        newPlaylistFieldLocator.sendKeys(name,Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(NotificationLocator));
        return this;
    }
}
