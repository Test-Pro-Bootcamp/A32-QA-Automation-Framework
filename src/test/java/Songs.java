import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
public class Songs extends BaseTest {
    @Test
    public void playSongTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        clickPlayBtn();
        Assert.assertTrue(pauseBtnExists());
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item"));
        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/queue");
        softAssert.assertTrue(songsNumberBefore == songsNumberAfter, "=== Songs number before should be equal songs number after ===");
        softAssert.assertAll();
    }

    public void clickPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action.moveToElement(playBtn).perform();
        playBtn.click();
    }
    public boolean pauseBtnExists(){
        return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }
}
