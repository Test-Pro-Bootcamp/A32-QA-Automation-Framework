package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    String nameNewPlaylist = "AutomationGuru";
    String playlistName = "NuGroove";
    String newName = "NuAutomationGuruGroove";
    String topPlaylist = ".playlist:nth-child(3)";

    By searchFieldLocator = By.cssSelector("input[placeholder='Press F to search']");
    By testNewPlaylistLocator = By.xpath("//li/a[text()='" + nameNewPlaylist + "']");
    By deletePlaylistLocator = By.xpath("//button[@title='Delete this playlist']");
    By createPlaylistLocator = By.xpath("//i[@title='Create a new playlist']");
    By newPlaylistLocator = By.xpath("//li[text()='New Playlist']");
    By nameFieldLocator = By.xpath("//section[@id='playlists']//input[@name='name']");
    By testPlaylistNameLocator = By.xpath("//li/a[text()='" + playlistName + "']");



    public MainPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean findSearchField() {
        driver.findElement(searchFieldLocator).isDisplayed();
        return true;
    }

    public void searchPlaylist() {
        WebElement testPlaylist;
        testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(testNewPlaylistLocator));
        testPlaylist.click();
    }

    public void createNewPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable
                (createPlaylistLocator)).click();
        WebElement newPlaylist = driver.findElement(newPlaylistLocator);
        newPlaylist.click();
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (testPlaylistNameLocator));
        testPlaylist.click();
    }

    private WebElement editingField(){
        By editLocator = By.xpath("//*[@data-testid='inline-playlist-name-input']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editLocator));
        return driver.findElement(editLocator);
    }

    public void renamePlaylist() {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(topPlaylist)));
        Actions actions = new Actions(driver);
        actions.doubleClick(playList).perform();
        editingField().sendKeys(Keys.CONTROL+"A");
        editingField().sendKeys(newName);
        editingField().sendKeys(Keys.RETURN);
    }

    public boolean confirmPlaylistCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li/a[text()='" + playlistName + "']")));
        return true;
    }
    public boolean confirmPlaylistExists() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li/a[text()='" + newName + "']")));
        return true;
    }

}
