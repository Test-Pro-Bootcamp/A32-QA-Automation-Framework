import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Scanner;

public class Homework17 extends BaseTest{
  //  @Test
    //public static void CreatePlaylist() {


      //  loginKoel();


       // WebElement createNewPlaylist = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
      //  createNewPlaylist.click();
     //   WebElement newPlaylist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
      //  newPlaylist.click();

      //  WebElement playlistInput = driver.findElement(By.xpath("//input[@name='name']"));
      //  playlistInput.sendKeys("My playlist");

        //I tried to find code for pressing Enter button. But I did it wrong and I don't know how to fix it

       // Scanner keybord = new Scanner(System.in);
       // keybord.nextLine();


      //  WebElement student = driver.findElement(By.xpath("//a[text()='My playlist']"));
      //  Assert.assertTrue(student.isDisplayed());
   // }


    @Test
    public static void addSongToPlaylist() {
        login();

        WebElement allSongs = driver.findElement(By.xpath("//a[@href=\"#!/songs\"]"));
        allSongs.click();
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
