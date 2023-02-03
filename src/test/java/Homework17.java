
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Homework17 extends BaseTest{
    @Test
    public static void addSongToPlaylist()  {

        enterEmail("ksenia.strigkova@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        clickAllSongs();
        chooseSong();
        clickAddTo();
        checkSongInAlbum();



    }
    public static void clickAllSongs() {
        WebElement clickAllSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        clickAllSongs.click();

    }
    private static void chooseSong() {
        WebElement song = driver.findElement(By.cssSelector(".all-songs .song-item:nth-of-type(5) .title"));
        song.click();

    }

    private static void clickAddTo() {
        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();
        WebElement addToPlaylist = driver.findElement(By.cssSelector("section#songsWrapper .existing-playlists > ul > .playlist"));
        addToPlaylist.click();

    }


    public static void checkSongInAlbum() {
        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]"));
        myPlaylist.click();
        WebElement songcheck = driver.findElement(By.cssSelector(".all-songs .song-item:nth-of-type(5) .title"));
        songcheck.isDisplayed();
    }


}



