import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        enterEmail("kamilakk@bk.ru");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement selectAllSong = driver.findElement(By.xpath("//*[@class='songs']"));
        selectAllSong.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectOneSong = driver.findElement(By.xpath("//section[@id='songsWrapper']/div/div/div/table/tr/td[text()='Take my Hand (ID 1696)']"));
        selectOneSong.click();
        WebElement selectAddTo = driver.findElement(By.xpath("//*[@class='btn-add-to']"));
        selectAddTo.click();
        WebElement selectPlayList = driver.findElement(By.xpath("//section[@id='songsWrapper']/header/div/div/section/ul/li[contains(text(),'NewPlaylist')]"));
        selectPlayList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement checkPlayList = driver.findElement(By.xpath("//*[@href='#!/playlist/41863']"));
        checkPlayList.click();
        WebElement checkOneSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']/div/div/div/table/tr/td[text()='Take my Hand (ID 1696)']"));
        Assert.assertTrue(checkOneSong.isDisplayed());
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

}