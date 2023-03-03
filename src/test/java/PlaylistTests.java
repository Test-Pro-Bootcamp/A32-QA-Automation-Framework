import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void a_createPlaylist() {
        String playlistName = "Test Pro 1";

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.addPlaylist()
                .selectPlaylist();
        homePage.enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
    }

    @Test
    public void b_addSongPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .randomSongsClick()
                .clickAddButton()
                .choosePlaylistInAddButton();
        Assert.assertTrue(homePage.notificationText());
    }

    @Test
    public void c_deleteSongFromPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickFirsPlaylist();
        songsPage.chooseListSongsInPlaylist()
                .chooseFirstSongPlaylist()
                .deleteSongFromPlaylist();
        Assert.assertTrue(homePage.notificationText());

    }

    @Test
    public void d_renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.doubleClickFirstPlaylist()
                .enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }

    @Test
    public void e_deletePlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.chooseFirstPlaylist()
                .deletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }
}