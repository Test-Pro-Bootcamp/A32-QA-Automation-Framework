package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "title")
    private WebElement titleLocator;
    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playButtonLocator;
    @FindBy(css = "[data-testid='pause-btn']")
    private WebElement pauseButtonLocator;
    @FindBy(xpath = "//a[text()='All Songs']")
    private WebElement allSongsLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement userPlaylistElement3;
    @FindBy(css = "input[name='name']")
    private WebElement userPlaylistInputField;
    @FindBy(css = ".success")
    private WebElement successBanerLocator;
    @FindBy(css = ".song-item")
    private WebElement firstSongInList;
    @FindBy(css = ".playback")
    private WebElement playBtnFromList;
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement barLocator;
    @FindBy(css = "#songsWrapper .fa-random")
    private WebElement allShuffleLocator;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public static void playlistDelete() {

    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public WebElement title() {
        return titleLocator;
    }

    public void clickPlayBtn() {
        actions.moveToElement(playButtonLocator).perform();
        actions.click(playButtonLocator);
    }

    public WebElement pauseBtnExists() {
        return pauseButtonLocator;
    }

    public void goToAllSongs() {
        allSongsLocator.click();
    }

    public Pages.HomePage doubleClickChoosePlaylist() {
        actions.doubleClick(userPlaylistElement3).perform();
        return this;
    }

    public void clickOnPlaylist() {
        userPlaylistElement3.click();
    }

    public homePage enterPlaylistName(String name) {
        userPlaylistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
        return this.allShuffle();
    }

    public String getPlaylistName() {
        return userPlaylistElement3.getText();
    }

    public boolean SuccessBanner() {
        return successBanerLocator.isDisplayed();
    }

    public Pages.HomePage choosePlayFromList() {
        actions.contextClick(firstSongInList).perform();
        return this;
    }

    public Pages.HomePage playBtnClick() {
        playBtnFromList.click();
        return this;
    }

    public boolean barIsDisplayed() {
        return barLocator.isDisplayed();
    }

    public homePage allShuffle() {
        allShuffleLocator.click();
        return this.allShuffle();
    }

    public class homePage extends BasePage {
        @FindBy(css = ".btn-delete-playlist")
        private WebElement playlistDeleteButton;

        public homePage(WebDriver givenDriver) {
            super(givenDriver);
        }

        public homePage playlistDelete() {
            playlistDeleteButton.click();
            return this;
        }
    }
}