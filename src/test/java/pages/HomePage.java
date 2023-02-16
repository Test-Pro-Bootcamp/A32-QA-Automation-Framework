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
    public HomePage(WebDriver setDriver) {
        super(setDriver);
    }
    public HomePage enterPlaylist() {
        doubleClick(playlistLocator);
        return this;
    }
    public HomePage changePlaylistName(String playlist) {
        playlistFieldLocator.sendKeys(Keys.CONTROL + "a");
        playlistFieldLocator.sendKeys(Keys.DELETE);
        playlistFieldLocator.sendKeys(playlist, Keys.ENTER);
        return this;
    }
    public HomePage deleteActions(){
        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistLocator.click();
        playlistPage.getDeleteButton().click();
        return this;
    }
    public WebElement getNotification(){
        return NotificationLocator;
    }
    public WebElement getAvatar(){
        return avatarLocator;
    }
    public HomePage createNewPlaylist(){
        createPlaylistBtnLocator.click();
        newPlaylistBtnLocator.click();
        return this;
    }
    public HomePage setPlaylistName(String name){
        newPlaylistFieldLocator.sendKeys(name,Keys.ENTER);
        return this;
    }
}
