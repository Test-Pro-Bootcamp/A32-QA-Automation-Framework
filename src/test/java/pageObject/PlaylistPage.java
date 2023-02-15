package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage {
    @FindBy(css = ".btn-delete-playlist")
    private WebElement playlistDeleteButton;
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public PlaylistPage playlistDelete() {
        playlistDeleteButton.click();
        return this;
    }
}
