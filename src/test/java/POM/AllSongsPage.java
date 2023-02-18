package POM;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage {
    By allSongList = By.cssSelector("[class='song-list-wrap main-scroll-wrap all-songs']");
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getAllSongs (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allSongList));
    }
    public void songDoubleClick() {
        Actions act = new Actions(driver);
        WebElement songDoubleClick = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[class='song-item']")));
        act.doubleClick(songDoubleClick).perform();
    }
    public void openPlaylistPage() {
        WebElement myPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='My playlist']")));
        myPlaylist.click();
    }
    public void open_m_Playlist() {
        WebElement playlist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='m']")));
        playlist.click();
    }
    public void selectSong() {
        WebElement song = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//td[@class='title']")));
        song.click();
    }
    public void addToClick() {
        WebElement addTo = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
    }
    public void selectPlaylist() {
        WebElement mPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[@class='playlist']")));
        mPlaylist.click();
    }
}
