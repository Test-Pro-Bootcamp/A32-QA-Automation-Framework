import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        login("burkovads@mail.ru","Julka@0721");
        userPlaylistFirst();
        deleteUserPlaylist();
        displayedNotification();
    }

    public void userPlaylistFirst() {
        WebElement userPlaylist = driver.findElement(By.cssSelector("[class='playlist playlist']"));
        userPlaylist.click();
    }
    public void deleteUserPlaylist() {
        WebElement deleteUserPlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deleteUserPlaylist.click();
    }

    public void displayedNotification() {
        WebElement notification = driver.findElement(By.cssSelector(".success"));
        notification.isDisplayed();
    }
}
