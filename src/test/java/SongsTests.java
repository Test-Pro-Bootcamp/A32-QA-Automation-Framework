import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    @Test
    public void playSongWithMenu() {
        LoginPage loginPage = new LoginPage( getThreadLocal());
        SongsPage songsPage = new SongsPage( getThreadLocal());

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();
        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }

    @Test
    public void playSongDoubleClick() {
        LoginPage loginPage = new LoginPage( getThreadLocal());
        SongsPage songsPage = new SongsPage( getThreadLocal());

        loginPage.provideLoginSucceed();
        songsPage.clickAllSongs()
                .chooseAllSongList()
                .doubleClickFirstSong();
        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }

    @Test
    public void searchSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickSearchField()
                .enterSearchSongs("Reactor");
        Assert.assertTrue(homePage.doesSearchResultExist("Reactor"));
    }
}