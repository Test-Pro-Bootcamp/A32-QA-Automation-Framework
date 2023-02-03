import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest {
    @Test
    public void PlaySong(){
        enterEmail("ksenia.strigkova@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        playSong();
        checkPlay();
    }
    private void playSong() {
        WebElement song= driver.findElement(By.cssSelector(".top-song-list > li:nth-of-type(2) > article > .cover"));
        song.click();
    }
    private void checkPlay() {
        WebElement progressBar = driver.findElement(By.cssSelector(".plyr__progress > .plyr__progress--played"));
        progressBar.isDisplayed();
    }
}
