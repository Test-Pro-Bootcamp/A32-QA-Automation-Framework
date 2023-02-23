package PageFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KoelPlaylistPage extends KoelBasePage {
    @FindBy(css = ".btn-delete-playlist")
    private WebElement playlistDeleteBTN;
    public KoelPlaylistPage(WebDriver driver) {
        super(driver);
    }
    public KoelPlaylistPage playlistDelete() {
        playlistDeleteBTN.click();
        return this;
    }
}
