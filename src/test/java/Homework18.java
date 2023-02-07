import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest{

    @Test
    public void playASongTest(){
        openLoginUrl();
        login("demo@class.com","te$t$tudent");
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        playSong();
        Assert.assertTrue(confirmPauseButtonExists());
    }

    private void playSong() {
        Actions action = new Actions(myDriver); //Creating object of Actions class
        WebElement playButton = myDriver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action.moveToElement(playButton).perform();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        playButton.click();
    }
    private boolean confirmPauseButtonExists() {
        WebElement pauseButton = myDriver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        return (pauseButton.isDisplayed());
    }
}
