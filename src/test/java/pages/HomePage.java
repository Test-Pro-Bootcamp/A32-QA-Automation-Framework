package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private final By NotificationLocator = By.cssSelector("[class='success show']");
    private final By playlistLocator = By.xpath("//li[@class='playlist playlist']");
    private final By playlistFieldLocator = By.cssSelector("[data-testid='inline-playlist-name-input']");
    private final By avatarLocator = By.cssSelector(".avatar");
    private final By createPlaylistBtnLocator = By.cssSelector("[title='Create a new playlist']");
    private final By newPlaylistBtnLocator = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private final By newPlaylistFieldLocator= By.cssSelector("input[name='name']");
    public void enterPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.presenceOfElementLocated(playlistLocator));
        actions.doubleClick(playlist).perform();
    }
    public void changePlaylistName(String playlist) {
        WebElement playlistField = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistFieldLocator));
        playlistField.sendKeys(Keys.CONTROL + "a");
        playlistField.sendKeys(Keys.DELETE);
        playlistField.sendKeys(playlist, Keys.ENTER);
    }
    public void deleteActions(){
        PlaylistPage playlistPage = new PlaylistPage();
        WebElement playlist= wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        playlist.click();
        WebElement deleteButton = playlistPage.getDeleteButton();
        deleteButton.click();
        //wait.until(ExpectedConditions.elementToBeClickable(playlistPage.getDeleteButton()));

    }
    public WebElement getNotification(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(NotificationLocator));
    }
    public WebElement getAvatar(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(avatarLocator));
    }
    public void createNewPlaylist(){
        WebElement createPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(createPlaylistBtnLocator));
        createPlaylistButton.click();
        WebElement newPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(newPlaylistBtnLocator));
        newPlaylistBtn.click();
    }
    public void setPlaylistName(String name){
        WebElement newPlaylistField = wait.until(ExpectedConditions.presenceOfElementLocated(newPlaylistFieldLocator));
        newPlaylistField.sendKeys(name,Keys.ENTER);
    }
}
