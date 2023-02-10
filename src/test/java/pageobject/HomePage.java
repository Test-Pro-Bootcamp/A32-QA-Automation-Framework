package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");

    By playlistInputField = By.cssSelector("input[name='name']");

    public void doubleClickFirstPlaylist() {
        doubleClick(driver.findElement(firstPlaylist));
    }
    public void enterPlaylistName(String playlistName) {
        driver.findElement(playlistInputField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        driver.findElement(playlistInputField).sendKeys(playlistName);
        driver.findElement(playlistInputField).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
        return playlistElement.isDisplayed();
    }


}




























