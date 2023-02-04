import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlayList(){
        openLoginUrl();
        login("demo@class.com","te$t$tudent");
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pickSong();


    }

    private void pickSong() {
        WebElement song = myDriver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = myDriver.findElement(By.xpath("//section[@id='playlists']//li[5]"));
        Actions acts = new Actions(myDriver);
        acts.clickAndHold(song).release(playlist).build().perform();

        playlist.click();
    }


}
