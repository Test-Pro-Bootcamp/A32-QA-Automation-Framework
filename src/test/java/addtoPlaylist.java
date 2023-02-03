import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class addtoPlaylist extends BaseTest {
    @Test
    public static void addSongtoPlaylist() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailadress = driver.findElement(By.cssSelector("[type='email']"));
        emailadress.click();
        emailadress.sendKeys("demotesting@gmail.com");
        WebElement passwordfield = driver.findElement(By.cssSelector("[type='password']"));
        passwordfield.click();
        passwordfield.sendKeys("te$t$tudent");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        WebElement AllSongs = driver.findElement(By.xpath("//*[@class='songs']"));
        AllSongs.click();
        WebElement Favorite = driver.findElement(By.xpath("//tr[1]/td[6]/button/i"));
        Favorite.click();
        driver.quit();

    }








}
