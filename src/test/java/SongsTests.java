import POM.*;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest {
    @Test
    public static void playSong() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginpage.provideEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.getUsrAvatar();
        homepage.navigateToAllSongs();
        allSongsPage.songDoubleClick();
        homepage.songIsPlaying();
    }
}
