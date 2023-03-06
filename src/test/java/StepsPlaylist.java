import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class StepsPlaylist extends BaseTest {

    public StepsPlaylist stepCreatedPlaylist() {

        String playlistName = "Test Pro 1";

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.addPlaylist()
                .selectPlaylist();
        homePage.enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
        return this;
    }

    public StepsPlaylist stepAddSongPlaylist() {

        SongsPage songsPage = new SongsPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        songsPage.clickAllSongs()
                .chooseAllSongList()
                .randomSongsClick()
                .clickAddButton()
                .choosePlaylistInAddButton();
        Assert.assertTrue(homePage.notificationText());
        return this;
    }

    public StepsPlaylist stepDeletePlaylist () {

        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        homePage.chooseFirstPlaylist();
        songsPage.clickDeletePlaylistButton();
        Assert.assertTrue(homePage.notificationText());
        return this;
    }

    public StepsPlaylist stepDeletePlaylistWithOK () {

        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        homePage.chooseFirstPlaylist();
        songsPage.clickDeletePlaylistButton()
                .clickOkDelete();
        Assert.assertTrue(homePage.notificationText());
        return this;
    }

    public StepsPlaylist stepDeleteSongFromPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        homePage.clickFirsPlaylist();
        songsPage.chooseListSongsInPlaylist()
                .chooseFirstSongPlaylist()
                .deleteSongFromPlaylist();
        Assert.assertTrue(homePage.notificationText());
        return this;
    }
    public StepsPlaylist stepRenamePlaylist() {

        String playlistName = "Test Pro Playlist";

        HomePage homePage = new HomePage(getThreadLocal());

        homePage.doubleClickFirstPlaylist()
                .enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
        return this;
    }
}
