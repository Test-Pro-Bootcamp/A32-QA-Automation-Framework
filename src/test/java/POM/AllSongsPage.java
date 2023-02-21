package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AllSongsPage extends BasePage {

    @FindBy(css= "[class='song-list-wrap main-scroll-wrap all-songs']")
    private WebElement allSongList;
    @FindBy(css= "[class='song-item']")
    private WebElement songItem;
    @FindBy(xpath="//a[text()='My playlist']")
    private WebElement myPlaylist;
    @FindBy(xpath="//a[text()='m']")
    private WebElement mPlaylist;

    @FindBy(xpath="//button[@class='btn-add-to']")
    private WebElement addToButton;
    @FindBy(xpath="//li[@class='playlist']")
    private WebElement playlistSelect;
    @FindBy(xpath="//div[class='success show']")
    private WebElement successsongAdded;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css="[class='title']")
    private WebElement songTitle;


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getAllSongs() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) allSongList));
    }

    public void songDoubleClick() {
        Actions act = new Actions(driver);
        WebElement songDoubleClick = wait.until(ExpectedConditions
                .elementToBeClickable(songItem));
        act.doubleClick(songDoubleClick).perform();
    }

    public void openPlaylistPage() {
        WebElement openMyPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(firstPlaylist));
        openMyPlaylist.click();
    }

    public void open_m_Playlist() {
        WebElement playlist = wait.until(ExpectedConditions
                .elementToBeClickable(firstPlaylist));
        playlist.click();
    }

    public void selectSong() {
        WebElement song = wait.until(ExpectedConditions
                .elementToBeClickable(songItem));
        song.click();
    }

    public void addToClick() {
        WebElement addTo = wait.until(ExpectedConditions
                .elementToBeClickable(addToButton));
        addTo.click();
    }

    public void selectPlaylist() {
        WebElement mPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(playlistSelect));
        mPlaylist.click();
    }

    public void verifySongIsAdded() {
        WebElement title = wait.until(presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        System.out.println(text);
        System.out.println("Is element visible? === " + wait.until(invisibilityOfElementLocated(By.cssSelector("title"))));
    }
}
