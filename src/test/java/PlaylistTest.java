import PageFolder.HomePage;
import PageFolder.LoginPage;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "ShineBest";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideLoginSucceed();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
    }
}
