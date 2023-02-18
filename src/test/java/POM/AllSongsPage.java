package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AllSongsPage extends BasePage {
    By allSongList = By.cssSelector("[class='song-list-wrap main-scroll-wrap all-songs']");
    By songItem = By.cssSelector("[class='song-item']");
    By myPlaylist = By.xpath("//a[text()='My playlist']");
    By mPlaylist = By.xpath("//a[text()='m']");
    //By songLocator = By.cssSelector("//section[@id='playlistWrapper']//td[@class='title']");
    By addToButton = By.xpath("//button[@class='btn-add-to']");
    By playlistSelect = By.xpath("//li[@class='playlist']");
    By successsongAdded = By.xpath("//div[class='success show']");


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getAllSongs() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allSongList));
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
        // WebElement songPlaylist = driver.findElement(successsongAdded);
        // Assert.assertTrue(songPlaylist.isDisplayed());
        WebElement title = wait.until(presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        System.out.println(text);
        System.out.println("Is element visible? === " + wait.until(invisibilityOfElementLocated(By.cssSelector("title"))));
    }
}
