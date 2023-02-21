import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        SongsPage songsPage = new SongsPage(getThreadDriver());

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();

        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }
}