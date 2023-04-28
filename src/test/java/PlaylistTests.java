import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;

public class PlaylistTests extends BaseTest {
    @Test(priority = 1)
    public void createPlaylist() {
        String createdPlaylistName = "Spring vibe";
        String notifyCreatedPlaylist = "Created playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.createPlaylistButton();
        homePage.newPlaylistCreate();
        homePage.enterNewPlaylistName(createdPlaylistName);
        homePage.showSuccessBanner();
    }

    @Test(priority = 2)
    public void addSongToPlaylist() {
        LoginPage loginPage =  new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.clickAddToButton();
        allSongsPage.selectFirstPlaylist();
        Assert.assertTrue(allSongsPage.showNotification());
    }
    @Test(priority = 4)
    public void renamePlaylist() {
        // double click
        String newPlaylistName = "Winter";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName(newPlaylistName);
        homePage.showSuccessBanner();
    }
    @Test(priority = 3)
    public void deleteSongFromPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginPage.login();
        homePage.clickPlaylist();
        playlistPage.clickFirstSong();
        playlistPage.deleteFirstSong();
        homePage.showSuccessBanner();

    }
    @Test(priority = 5)
    public void deletePlaylistTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        homePage.clickOnPlaylist();
        playlistPage.playlistDelete();
        homePage.SuccessBanner();
    }


}
