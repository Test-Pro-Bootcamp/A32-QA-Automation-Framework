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
    @FindBy(css = ".songs")
    private WebElement allSongsLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement userPlaylistElement3;
    @FindBy(css = "input[name='name']")
    private WebElement userPlaylistInputField;
    @FindBy(css = ".success")
    private WebElement successBanerLocator;
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
    public boolean pauseBtnExists() {
        return pauseButtonLocator.isDisplayed();
    }
    public void goToAllSongs() {
        allSongsLocator.click();
    }
    public void doubleClickChoosePlaylist() {
        actions.doubleClick(userPlaylistElement3).perform();
    }
    public void clickOnPlaylist() {
        userPlaylistElement3.click();
    }
    public void enterPlaylistName(String name) {
        userPlaylistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        userPlaylistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        return userPlaylistElement3.getText();
    }
    public boolean SuccessBanner() {
        return successBanerLocator.isDisplayed();
    }
}
