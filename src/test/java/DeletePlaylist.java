import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylist extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail("rumkostia92@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        deleteActions();
        isPlaylistDeleted();





    }
    public void deleteActions(){
        WebElement playlist = driver.findElement(By.cssSelector("li[class='playlist playlist']"));
        playlist.click();
        WebElement deleteButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deleteButton.click();

    }
    public void isPlaylistDeleted(){
        WebElement notification = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(notification.isDisplayed());
    }
}
