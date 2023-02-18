import POM.AllSongsPage;
import POM.HomePage;
import POM.LoginPage;
import POM.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public static void createPlaylist() {
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        homepage.createNewPlaylist();
        homepage.selectNewPlaylist();
        homepage.enterPlaylistName();
        homepage.verifyPlaylistCreated();
    }

    @Test
    public static void addSongToPlaylist() {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        homepage.navigateToAllSongs();
        allSongsPage.selectSong();
        allSongsPage.addToClick();
        allSongsPage.selectPlaylist();
        allSongsPage.open_m_Playlist();
        playlistPage.verifySongIsAdded();
        Assert.assertTrue(allSongsPage.getAllSongs().isDisplayed());
    }
    @Test
    public static void renamePlaylist() {
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        homepage.playlistDoubleClick();
        homepage.renamePlaylistName();
        homepage.verifyPlaylistRenamed();
    }

    @Test
    public static void deletePlaylist() {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        allSongsPage.openPlaylistPage();
        playlistPage.clickDeleteBtn();
        playlistPage.verifySuccessDeleted();
    }
}
