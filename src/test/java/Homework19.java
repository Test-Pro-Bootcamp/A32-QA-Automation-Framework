import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

public class Homework19 extends BaseTest {
    @Test
    public static void deletePlaylist() {

        enterEmail("ksenia.strigkova@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        clickMyPlaylist();
        deleteMyPlaylist();
        Assert.assertNotEquals(driver.getCurrentUrl(), urlHome);
    }

    public static void clickMyPlaylist() {
        WebElement playlist = driver.findElement(By.linkText("Ksenia"));
        playlist.click();
    }

    public static void deleteMyPlaylist() {
        WebElement deleteButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deleteButton.click();
    }
}
