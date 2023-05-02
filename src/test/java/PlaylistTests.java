import io.cucumber.java.bs.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;

public class PlaylistTests extends BaseTest {
    @Test(priority = 1)
    public void createPlaylist() throws InterruptedException {
        String createdPlaylistName = "Actual";
        String notifyCreatedPlaylist = "Created playlist";
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.login();
        Thread.sleep(2000);
        homePage.createPlaylistButton();
        homePage.newPlaylistCreate();
        homePage.enterNewPlaylistName(createdPlaylistName);
        Assert.assertTrue(homePage.showSuccessBanner(notifyCreatedPlaylist));
    }
    @Test(priority = 2)
    public void addSongToPlaylist() {
        LoginPage loginPage =  new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.selectFirstSong();
        allSongsPage.clickAddToButton();
        allSongsPage.selectFirstPlaylist();
        allSongsPage.showNotification();
        Assert.assertTrue(allSongsPage.showNotification());
    }
    @Test(priority = 3)
    public void deleteSongFromPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        String notifyRemovedSong = "Removed 1 song from";
        loginPage.login();
        homePage.clickPlaylist();
        Thread.sleep(2000);
        playlistPage.clickFirstSong();
        playlistPage.deleteFirstSong();
        homePage.showSuccessBanner(notifyRemovedSong);
        Assert.assertTrue(homePage.showSuccessBanner(notifyRemovedSong));
    }
    @Test(priority = 4)
    public void renamePlaylist() {
        // double click
        String newPlaylistName = "Winter";
        String notifyUpdatedPlaylist = "Updated playlist";
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.login();
        homePage.doubleClickSelectedPlaylist();
        homePage.enterPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.showSuccessBanner(notifyUpdatedPlaylist));
    }
    @Test(priority = 5)
    public void deletePlaylistTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        String notifyDeletedPlaylist = "Deleted playlist";
        loginPage.login();
        homePage.clickPlaylist();
        Thread.sleep(2000);
        playlistPage.deletePlaylist();
        Assert.assertTrue(homePage.showSuccessBanner(notifyDeletedPlaylist));
    }
}
