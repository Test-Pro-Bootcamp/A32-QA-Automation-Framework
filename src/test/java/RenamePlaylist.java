import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RenamePlaylist extends BaseTest{
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterEmail("rumkostia92@gmail.com")
        .enterPassword("te$t$tudent")
        .loginSubmit();
        homePage.enterPlaylist()
        .changePlaylistName("wao098132");
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}
