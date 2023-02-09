import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SongsTests extends BaseTest {
    @Test
    public void checkVisibilityTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        System.out.println(text);
        System.out.println("Is element invisible? === " + wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("title"))));
       // WebElement title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("title")));  // should fail
    }

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        List<WebElement> playlists = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        int playlistsNumber = playlists.size();
        playlists.get(playlistsNumber-1).click();
        WebElement playlistName = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        Thread.sleep(4000);
        String name = playlistName.getText();
        WebElement btnDeletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        btnDeletePlaylist.click();
        String notificationText = "Deleted playlist " + name;

        System.out.println(notificationText);
    }

}
