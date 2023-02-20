import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class DeletePlaylist extends  BaseTest {
    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterEmail("rumkostia92@gmail.com")
                .enterPassword("te$t$tudent")
                .loginSubmit();
        homePage.deleteActions();
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}
