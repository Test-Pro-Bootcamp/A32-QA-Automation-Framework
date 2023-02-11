package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class AllSongsPage extends BasePage {
    By firstSongInList = By.cssSelector(".song-item");
    By playBtnFromList = By.cssSelector(".playback");
    By barLocator = By.cssSelector("[data-testid='sound-bar-play']");
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public void choosePlayFromList () {
        WebElement firstSong = driver.findElement(firstSongInList);
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }
    public void playBtnClick () {
        WebElement playBtn = driver.findElement(playBtnFromList);
        playBtn.click();
    }
    public void barIsDisplayed () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(barLocator)).isDisplayed();
    }
}
