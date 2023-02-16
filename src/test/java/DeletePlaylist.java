import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class DeletePlaylist extends  BaseTest{
    @Test
    public void deletePlaylist()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("rumkostia92@gmail.com")
        .enterPassword("te$t$tudent")
        .loginSubmit();
        homePage.deleteActions();
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}
