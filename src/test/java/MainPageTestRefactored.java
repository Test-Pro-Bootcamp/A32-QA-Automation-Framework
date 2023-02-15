import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class MainPageTestRefactored extends BaseTest{
    @Test(description = "Another Kitty's Test")

    public void createAndRenamePlayListTest() {
        MainPage homePage = new MainPage(myDriver);
        LoginPage loginPage = new LoginPage(myDriver);
        openLoginUrl();
        loginPage.login();
        homePage.createNewPlayList();
        Assert.assertTrue(homePage.confirmPlaylistCreated(),"New playlist created");
        homePage.renamePlaylist();
        Assert.assertTrue(homePage.confirmPlaylistExists(),"Playlist renamed");
    }
}
