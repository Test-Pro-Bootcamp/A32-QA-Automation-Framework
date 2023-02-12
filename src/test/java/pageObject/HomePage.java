package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends BasePage {
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By titleLocator = By.cssSelector("title");
    private By playButtonLocator = By.cssSelector("[data-testid='play-btn']");
    private By pauseButtonLocator = By.cssSelector("[data-testid='pause-btn']");
    private By allSongsLocator = By.cssSelector(".songs");
    private By userPlaylistElement3 = By.cssSelector(".playlist:nth-child(3)");
    private By userPlaylistInputField = By.cssSelector("input[name='name']");
    private By successBanerLocator = By.cssSelector(".success");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar () {
        return wait.until((ExpectedConditions.visibilityOfElementLocated(userAvatarIcon)));
    }
    public WebElement title() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
    }
    public void clickPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(playButtonLocator);
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }
    public boolean pauseBtnExists() {
        return driver.findElement(pauseButtonLocator).isDisplayed();
    }
    public void goToAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsLocator)).click();
    }
    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(userPlaylistElement3));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }
    public void clickOnPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(userPlaylistElement3));
        playlistElement.click();
    }
    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(userPlaylistInputField);
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(userPlaylistElement3));
        return playlistElement.getText();
    }
    public void getSuccessBanner() {
        driver.findElement(successBanerLocator);
    }
}
