package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.DELETE;

public class PlaylistPage extends BasePage {
    @FindBy(css = ".btn-delete-playlist")
    private WebElement playlistDeleteButton;
    @FindBy(css = ".playlist [draggable]")
    private WebElement firstSong;
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public PlaylistPage playlistDelete() {
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

}
