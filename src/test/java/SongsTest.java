import POM.*;
import org.testng.annotations.Test;

public class SongsTest extends BaseTest {
    @Test
    public void verifySongIsPlaying() {
        LoginPage loginpage = new LoginPage(getThreadDriver());
        HomePage homepage = new HomePage(getThreadDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadDriver());
        loginpage.provideEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.getUsrAvatar();
        homepage.navigateToAllSongs();
        allSongsPage.songDoubleClick();
        homepage.songIsPlaying();
    }
}
