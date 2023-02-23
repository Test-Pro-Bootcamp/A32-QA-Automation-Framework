import PageFolder.KoelHomePage;
import PageFolder.KoelLoginPage;
import org.checkerframework.checker.units.qual.K;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {
    @Test
    public void validloginTest() {
        KoelLoginPage loginPage = new KoelLoginPage(getDriver());
        loginPage.enterEmail("demotesting@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSubmitbtn();
    }
    @Test
    public void createPlaylist() {
        String playlistName = "Shine-10";
        KoelLoginPage loginPage = new KoelLoginPage(getDriver());
        KoelHomePage homePage = new KoelHomePage(getDriver());

        loginPage.enterEmail("demotesting@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSubmitbtn();
        homePage.addPlaylist();
        homePage.selectPlaylist();
        homePage.enterPlaylistName(playlistName);
        homePage.notificationText();
    }
}
