package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    By playlistSongList = By.cssSelector("[class='song-list-wrap main-scroll-wrap playlist']");
    By playlistDeleteButton = By.cssSelector("[class='del btn-delete-playlist']");
    By successDelete = By.cssSelector("[class='success show']");

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getPlaylistSongs() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(playlistSongList));
    }

    public void clickDeleteBtn() {
        WebElement playlistDelete = wait.until(ExpectedConditions
                .elementToBeClickable(playlistDeleteButton));
        playlistDelete.click();
    }

    public void verifySuccessDeleted() {
        WebElement playlistDeleteSuccessShow = wait.until(ExpectedConditions
                .visibilityOfElementLocated(successDelete));
        Assert.assertTrue(playlistDeleteSuccessShow.isDisplayed());
    }
}
