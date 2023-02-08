import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{
    @Test
    public void PlaySong() {
        setUpBrowser("https://bbb.testpro.io/");
        enterEmail("burkovads@mail.ru");
        enterPassword("Julka@0721");
        loginSubmit();
        WebElement allSongs = driver.findElement(By.cssSelector(".songs"));
        allSongs.click();
        Actions actions = new Actions(driver);
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item .title"));
        actions.doubleClick(firstSong).perform();
        WebElement soundBars = driver.findElement(By.cssSelector(".bars"));
        Assert.assertTrue(soundBars.isDisplayed());
        tearDown();
    }
}
