import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void a_createPlaylist(){
        String playlistName = "Test Pro 1";

        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());
        BasePage basePage = new BasePage(getThreadDriver());

        loginPage.provideLoginSucceed();
        homePage.addPlaylist()
                .selectPlaylist();
        homePage.enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
    }

    @Test
    public void b_renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());

        loginPage.provideLoginSucceed();
        homePage.doubleClickFirstPlaylist()
                .enterPlaylistName(playlistName)
                .doesPlaylistExist(playlistName);
   }

    @Test
    public void c_deletePlaylist() {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());

        loginPage.provideLoginSucceed();
        homePage.chooseFirstPlaylist()
                .deletePlaylist();

        Assert.assertTrue(homePage.notificationText());
    }
}