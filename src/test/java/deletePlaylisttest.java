import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class deletePlaylisttest extends BaseTest {

    @Test
    public static void deletePlaylistTest() throws InterruptedException {
        logIn("demotesting@gmail.com", "te$t$tudent");
        openPlaylist();
        deletePlaylist();
        WebElement deletedplaylist = getDeletedplaylistmessage();
        Assert.assertTrue(deletedplaylist.isDisplayed());
    }
    public static WebElement getDeletedplaylistmessage() {
        WebDriver driver = new ChromeDriver();
        return driver.findElement(By.cssSelector("div.success.show"));
    }
    public static void openPlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    private static void deletePlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
}
