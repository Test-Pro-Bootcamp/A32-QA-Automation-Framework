import POM.*;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public static void createPlaylist() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.createNewPlaylist();
        homepage.selectNewPlaylist();
        homepage.enterPlaylistName();
        homepage.verifyPlaylistCreated();
    }

    @Test
    public static void addSongToPlaylist() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.navigateToAllSongs();
        allSongsPage.selectSong();
        allSongsPage.addToClick();
        allSongsPage.selectPlaylist();
        allSongsPage.openPlaylistPage();
        allSongsPage.verifySongIsAdded();
    }

    @Test
    public static void renamePlaylist() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.playlistDoubleClick();
        homepage.renamePlaylistName();
        homepage.verifyPlaylistRenamed();
    }

    @Test
    public static void deletePlaylist() {
        LoginPage loginpage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        allSongsPage.openPlaylistPage();
        playlistPage.clickDeleteBtn();
        playlistPage.verifySuccessDeleted();
    }
}
