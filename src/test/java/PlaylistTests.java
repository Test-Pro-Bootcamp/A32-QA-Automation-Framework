import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideLoginSucceed();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        homePage.doesPlaylistExist(playlistName);
    }
}