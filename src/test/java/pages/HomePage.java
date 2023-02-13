package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");
    By firsPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("input[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void doubleClickFirstPlaylist() {
        doubleClick(wait.until(ExpectedConditions.elementToBeClickable(firsPlaylist)));
    }
    public void enterPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(playlistName);
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+playlistName+"']")));
        return playlistElement.isDisplayed();
    }
}
