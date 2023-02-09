import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlayListTest() throws InterruptedException {
        openLoginUrl();
        login("demo@class.com", "te$t$tudent");
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        createNewPlayList();

        Thread.sleep(5000);
        deletePlaylist();

        Thread.sleep(5000);
        Assert.assertTrue(confirmPlaylistDeleted());
    }

    String nameNewPlaylist = "Goldcluster Test Playlist";

    public void createNewPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();
        WebElement newPlaylist = myDriver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();
        WebElement nameField = myDriver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(nameNewPlaylist, Keys.ENTER);
        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='" + nameNewPlaylist + "']")));
        testPlaylist.click();
    }

    public void deletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
    }

    public boolean confirmPlaylistDeleted() {
        List<WebElement> playlistNames = myDriver.findElements(By.xpath("//section[@id='playlists']//li/a"));

        for (WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals(nameNewPlaylist)) {
                Assert.assertTrue(false);
            }
        }
        return true;
    }
}
