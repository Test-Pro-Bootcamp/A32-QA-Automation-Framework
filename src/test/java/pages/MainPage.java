package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    String nameNewPlaylist = "AutomationGuru";
    String playlistName = "NuGroove";
    String newName = "NuAutomationGuruGroove";
    String topPlaylist = ".playlist:nth-child(3)";

    @FindBy(css = "input[placeholder='Press F to search']")
    private WebElement searchFieldLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement topPlayListlocator;
    @FindBy(xpath = "//button[@title='Delete this playlist']")
    private WebElement deletePlaylistLocator;
    @FindBy(xpath = "//i[@title='Create a new playlist']")
    private WebElement createPlaylistLocator;
    @FindBy(xpath = "//li[text()='New Playlist']")
    private WebElement newPlaylistLocator;
    @FindBy(xpath = "//section[@id='playlists']//input[@name='name']")
    private WebElement nameFieldLocator;
    By testPlaylistNameLocator = By.xpath("//li/a[text()='" + playlistName + "']");
    By testNewPlaylistNametLocator = By.xpath("//li/a[text()='" + nameNewPlaylist + "']");


    public MainPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean findSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchFieldLocator));
        return true;
    }

    public void searchRenamedPlaylist() {
        WebElement testPlaylist;
        testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(testNewPlaylistNametLocator));
        testPlaylist.click();
    }

    public void createNewPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable
                (createPlaylistLocator)).click();
        WebElement newPlaylist = newPlaylistLocator;
        newPlaylist.click();
        WebElement nameField = nameFieldLocator;
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (testPlaylistNameLocator));
        testPlaylist.click();
    }

    private WebElement editingField() {
        By editLocator = By.xpath("//*[@data-testid='inline-playlist-name-input']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editLocator));
        return driver.findElement(editLocator);
    }

    public void renamePlaylist() {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable
                (topPlayListlocator));
        Actions actions = new Actions(driver);
        actions.doubleClick(playList).perform();
        editingField().sendKeys(Keys.CONTROL + "A");
        editingField().sendKeys(newName);
        editingField().sendKeys(Keys.RETURN);
    }

    public boolean confirmPlaylistCreated() {
        return topPlayListlocator.isDisplayed();
    }

    public boolean confirmPlaylistExists() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li/a[text()='" + newName + "']")));
        return true;
    }

}
