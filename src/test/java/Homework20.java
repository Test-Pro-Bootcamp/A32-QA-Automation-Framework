import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest {
    String nameNewPlaylist = "AutomationGuruGroove";

    @Test
    public void createAndDeletePlayListTest(){
        openLoginUrl();
        login("vlina7078@yahoo.com", "te$t$tudent");
        createNewPlayList();
        deletePlaylist();
        Assert.assertTrue(confirmPlaylistDeleted());
    }
    //Methods

    public void createNewPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//i[@title='Create a new playlist']"))).click();
        WebElement newPlaylist = myDriver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();
        WebElement nameField = myDriver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(nameNewPlaylist, Keys.ENTER);
        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li/a[text()='" + nameNewPlaylist + "']")));
        testPlaylist.click();
    }

    public void deletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
    }

    public boolean confirmPlaylistDeleted() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//li/a[text()='" + nameNewPlaylist + "']")));
           return true;
    }
}



