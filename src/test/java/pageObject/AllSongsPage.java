package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    @FindBy(css = ".song-item")
    private WebElement firstSongInList;
    @FindBy(css = ".playback")
    private WebElement playBtnFromList;
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement barLocator;
    @FindBy(css = "#songsWrapper .fa-random")
    private WebElement allShuffleLocator;
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage choosePlayFromList () {
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
}
