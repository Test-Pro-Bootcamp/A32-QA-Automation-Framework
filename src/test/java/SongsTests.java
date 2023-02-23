import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();

        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }
}