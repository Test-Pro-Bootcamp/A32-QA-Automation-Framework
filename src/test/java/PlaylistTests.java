import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void renamePlaylist(){
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        homePage.doesPlaylistExist(playlistName);
    }

}
