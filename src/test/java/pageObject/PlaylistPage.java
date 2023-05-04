package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.Keys.DELETE;

public class PlaylistPage extends BasePage {
    @FindBy(css = ".btn-delete-playlist")
    private WebElement playlistDeleteButton;
    @FindBy(css = ".playlist [draggable]")
    private WebElement firstSong;
    @FindBy(css = ".success")
    private WebElement textNotification;
    @FindBy(css = ".msg")
    private WebElement messageNotification;
    @FindBy(css = ".ok")
    private WebElement okButton;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public PlaylistPage deletePlaylist() {
        playlistDeleteButton.click();
        return this;
    }
    public PlaylistPage clickFirstSong() {
        firstSong.click();
        return this;
    }
    public PlaylistPage deleteFirstSong() {
        actions.sendKeys(firstSong, DELETE).build().perform();
        return this;
    }
    public boolean showTextNotification() {
        return wait.until(ExpectedConditions.visibilityOf(textNotification)).isDisplayed();
    }
    public PlaylistPage clickOkButton() {
        okButton.click();
        return this;
    }
    public boolean showMessage() {
        return wait.until(ExpectedConditions.visibilityOf(messageNotification)).isDisplayed();
    }

}
