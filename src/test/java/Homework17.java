
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Scanner;
import org.openqa.selenium.Keys;
public class Homework17 extends BaseTest{

    @Test
    public static void CreatePlaylist() {


        loginKoel();
        WebElement createNewPlaylist = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylist.click();
        WebElement newPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
        WebElement playlistInput = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInput.sendKeys("My playlist");
        playlistInput.sendKeys(Keys.ENTER);
        WebElement student = driver.findElement(By.xpath("//a[text()='My playlist']"));
        Assert.assertTrue(student.isDisplayed());
    }


    @Test
    public static void addSongToPlaylist() {
        loginKoel();
        navigateToAllSongs();
        WebElement song = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[2]/td[2]"));
        song.click();
        WebElement addTo = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addTo.click();
        WebElement mPlaylist = driver.findElement(By.xpath("//li[@class='playlist']"));
        mPlaylist.click();
        WebElement playlist = driver.findElement(By.xpath("//a[text()='m']"));
        playlist.click();
        WebElement songPlaylist = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr[2]/td[2]"));
        songPlaylist.click();
        Assert.assertTrue(songPlaylist.isDisplayed());
    }


}
