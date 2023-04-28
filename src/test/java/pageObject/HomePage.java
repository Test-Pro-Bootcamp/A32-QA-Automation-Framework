package pageObject;
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
    private WebElement userPlaylist3;
    @FindBy(css = "input[name='name']")
    private WebElement userPlaylistInputField;
    @FindBy(css = ".success")
    private WebElement successBanerLocator;
    @FindBy(css = ".fa-plus-circle")
    private WebElement createPlaylistPlusLocator;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylist;
    @FindBy(css = ".view-profile")
    private WebElement profileLocator;
    @FindBy(css = ".fa-sign-out")
    private WebElement logoutButton;



    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
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
    public void clickPlaylist() {
        actions.moveToElement(userPlaylist3).perform();
        actions.click(userPlaylist3);
    }

    public WebElement pauseBtnExists() {
        return pauseButtonLocator;
    }

    public void goToAllSongs() {
        allSongsLocator.click();
    }

    public HomePage doubleClickSelectedPlaylist() { //Rename playlist
        actions.doubleClick(userPlaylist3).perform();
        return this;
    }
    public HomePage enterPlaylistName(String name) { //Rename playlist
        userPlaylistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public void clickOnPlaylist3() {userPlaylist3.click();
    }




    public boolean showSuccessBanner(String name) {
        return successBanerLocator.isDisplayed();
    } //Playlist


    public HomePage createPlaylistButton() { //create Playlist
        createPlaylistPlusLocator.click();
        return this;
    }
    public HomePage newPlaylistCreate() { //create Playlist
        newPlaylist.click();
        return this;
    }
    public HomePage enterNewPlaylistName(String name) { //create Playlist
        userPlaylistInputField.sendKeys(name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
        return this;
    }



    public HomePage openUserProfile() {
        profileLocator.click();
        return this;
    }
    public HomePage clickLogoutButton() {
        logoutButton.click();
        return this;
    }
}
