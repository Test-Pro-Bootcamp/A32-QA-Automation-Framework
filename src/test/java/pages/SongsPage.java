package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.DELETE;


public class SongsPage extends BasePage {

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".song-item")
    private List<WebElement> listAllSongs;
    @FindBy(css = ".song-item")
    private WebElement firstSongInSongList;
    @FindBy(css = ".playback")
    private WebElement playBtnFromList;
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement progressBar;
    @FindBy(css = ".songs")
    private WebElement allSongs;

    @FindBy(css = ".btn-add-to")
    private WebElement addToButton;

    @FindBy(css = "#songsWrapper .playlist")
    private WebElement selectPlaylistInAddButton;

    @FindBy(css = ".ok")
    private WebElement okButton;

    @FindBy(css = ".playlist [draggable]")
    private List<WebElement> listSongsInPlaylist;

    @FindBy(css = ".playlist .items .song-item:nth-of-type(1)")
    private WebElement firstSongPlaylist;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistButton;

    @FindBy(css = "nav > .ok")
    private WebElement okDeleteButton;

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

    public SongsPage randomSongsClick() {
        int indexOfRandomElement = new Random().ints(0, listAllSongs.size() - 1)
                .findFirst()
                .getAsInt();
        listAllSongs.get(indexOfRandomElement).click();
        return this;
    }

    public SongsPage clickAddButton() {
        addToButton.click();
        return this;
    }

    public SongsPage choosePlaylistInAddButton() {
        selectPlaylistInAddButton.click();
        return this;
    }

    public SongsPage doubleClickFirstSong() {
        doubleClick(firstSongInSongList);
        return this;
    }

    public SongsPage chooseListSongsInPlaylist() {
        listSongsInPlaylist.size();
        return this;
    }

    public SongsPage chooseFirstSongPlaylist() {
        firstSongPlaylist.click();
        return this;
    }

    public SongsPage deleteSongFromPlaylist() {
        actions.sendKeys(firstSongPlaylist, DELETE).build().perform();
        return this;
    }

    public SongsPage clickDeletePlaylistButton() {
        deletePlaylistButton.click();
        return this;
    }

    public SongsPage clickOkDelete() {
        okDeleteButton.click();
        return this;
    }
}