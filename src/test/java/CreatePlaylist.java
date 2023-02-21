import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CreatePlaylist extends BaseTest{
    @Test
    public void createPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterEmail("rumkostia92@gmail.com")
                 .enterPassword("te$t$tudent")
                 .loginSubmit();
        homePage.createNewPlaylist()
                .setPlaylistName("Papoij9a");
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}
