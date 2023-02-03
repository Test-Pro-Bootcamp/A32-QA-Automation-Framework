import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        enterEmail("kamilakk@bk.ru");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement selectAllSong = driver.findElement(By.xpath("//*[@class='songs']"));
        selectAllSong.click();
        Actions act = new Actions(driver);
        WebElement selectOneSong = driver.findElement(By.xpath("//section[@id='songsWrapper']/div/div/div/table/tr/td[text()='Scott Holmes Music - Epic Cinematic']"));
        act.doubleClick(selectOneSong).perform();
        WebElement checkOneSong = driver.findElement(By.xpath("//*[@alt='Sound bars']"));
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
