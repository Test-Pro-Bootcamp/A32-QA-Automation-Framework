package PageFolder;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KoelHomePage extends KoelBasePage {
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = ".fa-plus-circle")
    private WebElement addNewPlaylist;
    @FindBy(css = ".show.success")
    private WebElement notification;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement chooseCreateNewPlaylist;

    public KoelHomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public KoelHomePage enterPlaylistName(String playlistName){
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }
    public KoelHomePage addPlaylist() {
        addNewPlaylist.click();
        return this;
    }

    public KoelHomePage selectPlaylist() {
        chooseCreateNewPlaylist.click();
        return this;
    }

    public boolean notificationText() {
        return notification.isDisplayed();
    }
}
