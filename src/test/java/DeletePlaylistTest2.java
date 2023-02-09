import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylistTest2 extends BaseTest {
    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
        logIn("demotesting@gmail.com", "te$t$tudent");
        openPlaylist();
        deletePlaylist();
        WebElement deletedPlaylistmessage = getDeletedPlaylistmessage();
        Assert.assertTrue(deletedPlaylistmessage.isDisplayed());
    }
    public WebElement getDeletedPlaylistmessage() {
        WebDriver driver = new ChromeDriver();
        return driver.findElement(By.cssSelector("div.success.show"));
    }
    public void openPlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    private void deletePlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebElement deletePlaylistbtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistbtn.click();
        Thread.sleep(2000);
    }

}
