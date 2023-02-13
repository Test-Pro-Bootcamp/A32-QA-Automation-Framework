package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaylistPage extends BasePage {
    private final By playlistDeleteButton = By.cssSelector(".btn-delete-playlist");
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void playlistDelete() {
        WebElement playlistBtnDelete = driver.findElement(playlistDeleteButton);
        playlistBtnDelete.click();
    }
}
