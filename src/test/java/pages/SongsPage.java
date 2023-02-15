package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SongsPage extends BasePage {

    public SongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css= ".song-item")
    WebElement listAllSongs;
    @FindBy(css=".song-item")
    WebElement firstSongInSongList;
    @FindBy(css=".playback")
    WebElement playBtnFromList;
    @FindBy(css="[data-testid='sound-bar-play']")
    WebElement progressBar;

    public SongsPage chooseAllSongList() {
        allSongs.click();
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item"));
        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);
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
