import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class SongsTests extends BaseTest {
    @Test
    public void checkVisibilityTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        String text = homePage.title().getText();
        System.out.println(text);
        System.out.println("Is element invisible? === " + wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("title"))));
    }

    @Test
    public void deletePlaylistTest()  {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());
        loginPage.provideEmail("kamilakk@bk.ru")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        homePage.clickOnPlaylist();
        homePage.playlistDelete();
        homePage.SuccessBanner();
    }

}
