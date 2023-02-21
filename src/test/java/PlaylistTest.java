import PageFolder.KoelBasePage;
import PageFolder.KoelHomePage;
import PageFolder.KoelLoginPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public void createPlaylist() {
        String playlistName = "Shine-6";
        KoelLoginPage loginPage = new KoelLoginPage(driver);
        KoelHomePage homePage = new KoelHomePage(driver);

        loginPage.enterEmail("demotesting@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSubmitbtn();
        homePage.addPlaylist();
        homePage.selectPlaylist();
        homePage.enterPlaylistName(playlistName);
        homePage.notificationText();
    }
}
