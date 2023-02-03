import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        enterEmail("rumkostia92@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        playSongs();
        isSongPlaying();
    }
    public void playSongs() throws InterruptedException {
        WebElement playSong = driver.findElement(By.cssSelector("ol[class='top-song-list'] > li:nth-child(3) > article > span[class='cover']"));
        playSong.click();
        Thread.sleep(2000);
    }
    public void isSongPlaying(){
        WebElement soundBars = driver.findElement((By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(soundBars.isDisplayed(),"Yes sir!!!");
    }

}
