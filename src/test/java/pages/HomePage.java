package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    By NotificationLocator = By.cssSelector("[class='success show']");
    By playlistLocator = By.xpath("//li[@class='playlist playlist']");
    By playlistFieldLocator = By.cssSelector("[data-testid='inline-playlist-name-input']");
    By avatarLocator = By.cssSelector(".avatar");
    By createPlaylistBtnLocator = By.cssSelector("[title='Create a new playlist']");
    By newPlaylistBtnLocator = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By newPlaylistFieldLocator= By.cssSelector("input[name='name']");
    public void enterPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.presenceOfElementLocated(playlistLocator));
        Actions actions = new Actions(driver);
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
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(playlistPage.deleteButtonLocator));
        deleteButton.click();
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

