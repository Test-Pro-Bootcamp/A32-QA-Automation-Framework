package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    By playlistSongList = By.cssSelector("[class='song-list-wrap main-scroll-wrap playlist']");
    public PlaylistPage (WebDriver givenDriver)
    { super(givenDriver);}
    public WebElement getPlaylistSongs (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(playlistSongList));
    }
    public void verifySongIsAdded() {
        WebElement songPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr[2]/td[2]")));
        songPlaylist.click();
        Assert.assertTrue(songPlaylist.isDisplayed());
    }
    public void clickDeleteBtn() {
        WebElement playlistDelete = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        playlistDelete.click();
    }
    public void verifySuccessDeleted() {
        WebElement playlistDelete = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(playlistDelete.isDisplayed());
    }
}
