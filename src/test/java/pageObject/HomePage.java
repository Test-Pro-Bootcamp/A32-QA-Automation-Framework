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
    private WebElement userPlaylistElement3;
    @FindBy(css = "input[name='name']")
    private WebElement userPlaylistInputField;
    @FindBy(css = ".success")
    private WebElement successBanerLocator;
    @FindBy(css = ".fa-plus-circle")
    private WebElement createPlaylistPlusLocator;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylist;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar () {
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
    public HomePage doubleClickChoosePlaylist() {
        actions.doubleClick(userPlaylistElement3).perform();
        return this;
    }
    public void clickOnPlaylist() {
        userPlaylistElement3.click();
    }
    public HomePage enterPlaylistName(String name) {
        userPlaylistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public String getPlaylistName() {
        return userPlaylistElement3.getText();
    }
    public boolean successBanner() {
        return successBanerLocator.isDisplayed();
    }

    public HomePage createPlaylistButton() {
        createPlaylistPlusLocator.click();
        return this;
    }
    public HomePage newPlaylistCreate() {
        newPlaylist.click();
        return this;
    }
    public HomePage enterNewPlaylistName(String name) {
        userPlaylistInputField.sendKeys(name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
        return this;
    }
}
