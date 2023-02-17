import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTest extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();

        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }
}
