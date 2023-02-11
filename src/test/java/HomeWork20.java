import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        login("burkovads@mail.ru","Julka@0721");
        userPlaylistFirst();
        deleteUserPlaylist();
        displayedNotification();
    }

    public void userPlaylistFirst() {
        WebElement userPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='playlist playlist']")));
        userPlaylist.click();
    }
    public void deleteUserPlaylist() {
        WebElement deleteUserPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deleteUserPlaylist.click();
    }

    public void displayedNotification() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        Assert.assertTrue((notification.isDisplayed()));
    }
}
