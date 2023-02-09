import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylist extends BaseTest {
    @Test
    public void deletePlaylist()  {
        enterEmail("rumkostia92@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        deleteActions();
        isPlaylistDeleted();
    }
    public void deleteActions(){

        WebElement playlist= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='playlist playlist']")));
        playlist.click();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Delete this playlist']")));
        deleteButton.click();
    }
    public void isPlaylistDeleted(){
        WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(notification.isDisplayed());
    }
}
