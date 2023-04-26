import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;
public class SongsTests extends BaseTest {
    @Test
    public void checkVisibilityTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        String text = homePage.title().getText();
        System.out.println(text);
        System.out.println("Is element invisible? === " + wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("title"))));
       // WebElement title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("title")));  // should fail
    }
//    @Test
//    public void deletePlaylistTest() {
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        PlaylistPage playlistPage = new PlaylistPage(getDriver());
//        loginPage.provideEmail("burkovads@mail.ru")
//                .providePassword("Julka@0721")
//                .clickSubmitBtn();
//        homePage.clickOnPlaylist();
//        playlistPage.playlistDelete();
//        homePage.SuccessBanner();
//    }
}
