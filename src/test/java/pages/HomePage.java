package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = ".avatar")
    WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firsPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement playlistInputField;
    @FindBy(css = ".fa-plus-circle")
    WebElement addNewPlaylist;
    @FindBy(css = ".btn-delete-playlist")
    WebElement deletePlaylistBtn;
    @FindBy(css = ".show.success")
    WebElement notification;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public HomePage doubleClickFirstPlaylist() {
        doubleClick(firsPlaylist);
        return this;
    }

    public HomePage enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.isDisplayed();

    }

    public HomePage chooseFirstPlaylist() {
        firsPlaylist.click();
        return this;
    }

    public HomePage deletePlaylist() {
        deletePlaylistBtn.click();
        return this;
    }

    public boolean notificationText() {
        return notification.isDisplayed();
    }
}