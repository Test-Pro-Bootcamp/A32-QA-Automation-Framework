package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    @FindBy(css = "[class='song-list-wrap main-scroll-wrap playlist']")
    private WebElement playlistSongList;
    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement playlistDeleteButton;
    @FindBy(css = "[class='success show']")
    private WebElement successDelete;
    @FindBy(xpath="//button[@class='ok']")
    private WebElement deleteThePlaylist;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getPlaylistSongs() {
        return wait.until(ExpectedConditions.visibilityOf(playlistSongList));
    }

    public void clickDeleteBtn() {
         WebElement playlistDelete = wait.until(ExpectedConditions
                .elementToBeClickable(playlistDeleteButton));
        playlistDelete.click();}
       public void deleteOk() {
    WebElement msgDeletePlaylist = wait.until(ExpectedConditions.visibilityOf(deleteThePlaylist));
            msgDeletePlaylist.click();
    }

    public void verifySuccessDeleted() {
        WebElement playlistDeleteSuccessShow = wait.until(ExpectedConditions
                .visibilityOf(successDelete));
        Assert.assertTrue(playlistDeleteSuccessShow.isDisplayed());
    }
}
