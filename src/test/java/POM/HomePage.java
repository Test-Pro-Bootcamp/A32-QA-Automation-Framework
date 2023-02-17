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
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUsrAvatar (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.xpath("//input[@name='name']");

    public void doubleClickFirstPlaylist() {
        doubleclick(driver.findElement(firstPlaylist));
    }
    public void navigateToAllSongs() {
        WebElement navigateToAllSongsPage = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='#!/songs']")));
        navigateToAllSongsPage.click();
    }
    public void playlistDoubleClick() {
        Actions actn = new Actions(driver);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistDblClick = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actn.doubleClick(playlistDblClick).perform();
    }
    public void renamePlaylistName() {
        WebElement playlistRenameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input'")));
        playlistRenameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistRenameInput.sendKeys("My new playlist");
        playlistRenameInput.sendKeys(Keys.ENTER);
    }
    public void verifyPlaylistRenamed() {
        WebElement myNewPlaylist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[text()='My new playlist']")));
        Assert.assertTrue(myNewPlaylist.isDisplayed());
    }
    public void songIsPlaying() {
        WebElement songPlaying = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("[alt='Sound bars']")));
        Assert.assertTrue(songPlaying.isDisplayed());
    }
    public void createNewPlaylist() {
        WebElement createPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        createPlaylist.click();
    }
    public void selectNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }
    public void enterPlaylistName() {
        WebElement playlistInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@name='name']")));
        playlistInput.sendKeys("My playlist");
        playlistInput.sendKeys(Keys.ENTER);
    }
    public void verifyPlaylistCreated() {
        WebElement student = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[text()='My playlist']")));
        Assert.assertTrue(student.isDisplayed());
    }
}
