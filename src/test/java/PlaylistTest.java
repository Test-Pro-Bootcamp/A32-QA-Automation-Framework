import POM.*;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public void createPlaylist() {
        LoginPage loginpage = new LoginPage(getThreadDriver());
        HomePage homepage = new HomePage(getThreadDriver());
        loginpage.provideEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.createNewPlaylist();
        homepage.selectNewPlaylist();
        homepage.enterPlaylistName();
        homepage.verifyPlaylistCreated();
    }

    @Test
    public void addSongToPlaylist() {
        LoginPage loginpage = new LoginPage(getThreadDriver());
        HomePage homepage = new HomePage(getThreadDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadDriver());
        loginpage.provideEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.navigateToAllSongs();
        allSongsPage.selectSong();
        allSongsPage.addToClick();
        allSongsPage.selectPlaylist();
        allSongsPage.verifySongIsAdded();
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginpage = new LoginPage(getThreadDriver());
        HomePage homepage = new HomePage(getThreadDriver());
        loginpage.login();
        homepage.playlistDoubleClick();
        homepage.renamePlaylistName();
        homepage.verifyPlaylistRenamed();
    }

    @Test
    public void deletePlaylist() {
        LoginPage loginpage = new LoginPage(getThreadDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadDriver());
        PlaylistPage playlistPage = new PlaylistPage(getThreadDriver());
        loginpage.provideEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        allSongsPage.openPlaylistPage();
        playlistPage.clickDeleteBtn();
        playlistPage.deleteOk();
        playlistPage.verifySuccessDeleted();
    }
}
