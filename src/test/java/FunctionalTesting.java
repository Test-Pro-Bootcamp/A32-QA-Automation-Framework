import PageFolder.KoelBasePage;
import PageFolder.KoelHomePage;
import PageFolder.KoelLoginPage;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FunctionalTesting extends BaseTest {
    @Test
    public void TestLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io/");

        KoelLoginPage loginPage = new KoelLoginPage(driver);
        loginPage.enterEmail("demotesting@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSumbit();
    }
    @Test
    public void Createplaylist() {
        String Playlistname = "PlaylistTesting";
        KoelLoginPage loginPage = new KoelLoginPage(driver);
        KoelHomePage homepage = new KoelHomePage(driver);

        loginPage.enterEmail("demotesting@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSumbit();
        homepage.addPlaylist();
        homepage.selectPlaylist();
        homepage.enterPlaylistName(Playlistname);
        homepage.notificationText();
    }
}
