package pageObject;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class AllSongsPage extends BasePage {
    @FindBy(css = ".all-songs [draggable='true']:nth-of-type(1) .title")
    private WebElement firstSongInList;
    @FindBy(css = ".playback")
    private WebElement playBtnFromList;
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement barLocator;
    @FindBy(css = "#songsWrapper .fa-random")
    private WebElement allShuffleLocator;
    @FindBy(css = ".btn-add-to")
    private WebElement addToButton;
    @FindBy(css = "#songsWrapper ul .playlist:nth-of-type(5)")
    private WebElement firstPlaylistInDropdownList;
    @FindBy(css = ".success")
    private WebElement successBanner;
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage rightClickSong () {
        actions.contextClick(firstSongInList).perform();
        return this;
    }
    public AllSongsPage playBtnClick () {
        playBtnFromList.click();
        return this;
    }
    public boolean barIsDisplayed () {
        return barLocator.isDisplayed();
    }
    public AllSongsPage allShuffle() {
        allShuffleLocator.click();
        return this;
    }
    public AllSongsPage clickAddToButton() {
        addToButton.click();
        return this;
    }
    public AllSongsPage selectFirstPlaylist() {
        firstPlaylistInDropdownList.click();
        return this;
    }
    public boolean showNotification() {
        return wait.until(ExpectedConditions.visibilityOf(successBanner)).isDisplayed();
    }
    public AllSongsPage doubleClickSong() {
        actions.doubleClick(firstSongInList).perform();
        return this;
    }
    public AllSongsPage selectFirstSong() {
        firstSongInList.click();
        return this;
    }
}
