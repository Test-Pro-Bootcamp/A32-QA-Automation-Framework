package pageObject;
import io.cucumber.java.sl.In;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
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
    @FindBy(xpath = "//span[text()='Search Results for ']")
    private WebElement searchResultsTitle;
    @FindBy(css = "[type=\"search\"]")
    private WebElement searchField;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public HomePage clickPlaylist() {
        userPlaylist3.click();
        return this;
    }
    public HomePage goToAllSongs() {
        allSongsLocator.click();
        return this;
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
    public boolean showSearchResultTitle() {
        return searchResultsTitle.isDisplayed();
    }
    public HomePage clickSearchField() {
        searchField.click();
        return this;
    }
    public HomePage enterSearchSong(String name) throws InterruptedException {
        searchField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        searchField.sendKeys(name);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        return this;
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
        actions.moveToElement(logoutButton).perform();
        logoutButton.click();
        return this;
    }
}
