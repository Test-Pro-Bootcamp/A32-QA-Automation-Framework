import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;
public class SongsTests extends BaseTest {
    @Test
    public void playSongWithShuffleButtonTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.allShuffle();
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }
    @Test
    public void playSongByDoubleClickTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.doubleClickSong();
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }
    @Test
    public void playSongFromListTest() {
        // right click
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        loginPage.login();
        homePage.goToAllSongs();
        allSongsPage.rightClickSong();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }
    @Test
    public void searchSongTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.login();
        homePage.clickSearchField();
        homePage.enterSearchSong("Pluto");
        Thread.sleep(2000);
        Assert.assertTrue(homePage.showSearchResultTitle());
    }
}
