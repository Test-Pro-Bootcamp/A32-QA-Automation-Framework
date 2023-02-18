import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SongsTests extends BaseTest {
    @Test
    public static void playSong() {
         LoginPage loginpage = new LoginPage(driver);
         HomePage homepage = new HomePage(driver);
         AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginpage.provideEmailEmail("dashazhyrkova@gmail.com");
        loginpage.providePassword("te$t$tudent28");
        loginpage.clickSubmitBtn();
        homepage.navigateToAllSongs();
        allSongsPage.songDoubleClick();
        homepage.songIsPlaying();
    }
}
