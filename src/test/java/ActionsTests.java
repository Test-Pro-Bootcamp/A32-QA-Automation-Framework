import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ActionsTests extends BaseTest {

    @Test
    public void playSongTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.provideEmail("kamilakk@bk.ru")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        homePage.goToAllSongs();
        allSongsPage.allShuffle();
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }

    @Test
    public void renamePlaylist() {
        String playlistName = "Summer songs";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.login("kamilakk@bk.ru", "te$t$tudent");
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }


    @Test
    public void playSongFromListTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.login("kamilakk@bk.ru", "te$t$tudent");
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }
}
