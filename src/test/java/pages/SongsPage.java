package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class SongsPage extends BasePage {

    public SongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css= ".song-item")
    private List<WebElement> listAllSongs;
    @FindBy(css=".song-item")
    private WebElement firstSongInSongList;
    @FindBy(css=".playback")
    private WebElement playBtnFromList;
    @FindBy(css="[data-testid='sound-bar-play']")
    private WebElement progressBar;
    @FindBy(css = ".songs")
    private WebElement allSongs;

    public SongsPage clickAllSongs() {
        allSongs.click();
        return this;
    }

    public SongsPage chooseAllSongList() {
        allSongs.getSize();
        return this;
    }

    public SongsPage contextClickFirstSong() {
        contextClickSong(firstSongInSongList);
        return this;
    }
    public SongsPage choosePlay() {
        playBtnFromList.click();
        return this;
    }

    public WebElement getProgressBar() {
        return progressBar;
    }
}