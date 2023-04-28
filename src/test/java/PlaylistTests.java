import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;

public class PlaylistTests extends BaseTest {
    @Test
    public void createPlaylist() {
        String createdPlaylistName = "Actual";
        String notifyCreatedPlaylist = "Created playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.createPlaylistButton();
        homePage.newPlaylistCreate();
        homePage.enterNewPlaylistName(createdPlaylistName);
        Assert.assertTrue(homePage.showSuccessBanner(notifyCreatedPlaylist));
    }
    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage =  new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.selectFirstSong();
        allSongsPage.clickAddToButton();
        allSongsPage.selectFirstPlaylist();
        Assert.assertTrue(allSongsPage.showNotification());
    }
    @Test
    public void deleteSongFromPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        String notifyRemovedSong = "Removed 1 song from";
        loginPage.login();
        homePage.clickPlaylist();
        playlistPage.clickFirstSong();
        playlistPage.deleteFirstSong();
        Assert.assertTrue(homePage.showSuccessBanner(notifyRemovedSong));
    }
    @Test
    public void renamePlaylist() {
        // double click
        String newPlaylistName = "Winter";
        String notifyUpdatedPlaylist = "Updated playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.doubleClickSelectedPlaylist();
        homePage.enterPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.showSuccessBanner(notifyUpdatedPlaylist));
    }
    @Test
    public void deletePlaylistTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        String notifyDeletedPlaylist = "Deleted playlist";
        loginPage.login();
        homePage.clickPlaylist();
        playlistPage.deletePlaylist();
        Assert.assertTrue(homePage.showSuccessBanner(notifyDeletedPlaylist));
    }
}
