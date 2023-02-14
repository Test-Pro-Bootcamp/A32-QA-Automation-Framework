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
        doubleClick(playlistLocator);

    }
    public void changePlaylistName(String playlist) {

        WebElement playlistField = driver.findElement(playlistFieldLocator);
        playlistField.sendKeys(Keys.CONTROL + "a");
        playlistField.sendKeys(Keys.DELETE);
        playlistField.sendKeys(playlist, Keys.ENTER);
    }
    public void deleteActions(){
        PlaylistPage playlistPage = new PlaylistPage();
        click(playlistLocator);
        click(playlistPage.getDeleteButton());
    }
    public WebElement getNotification(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(NotificationLocator));
    }
    public WebElement getAvatar(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(avatarLocator));
    }
    public void createNewPlaylist(){
        click(createPlaylistBtnLocator);
        click(newPlaylistBtnLocator);
    }
    public void setPlaylistName(String name){
        driver.findElement(newPlaylistFieldLocator).sendKeys(name,Keys.ENTER);
    }
}
