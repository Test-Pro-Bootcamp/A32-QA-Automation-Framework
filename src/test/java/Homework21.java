import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {
    String playlistName = "NuGroove";
    String newName = "NuAutomationGuruGroove";
    String topPlaylist = ".playlist:nth-child(3)";

    @Test
    public void createAndRenamePlayListTest() throws InterruptedException {
        openLoginUrl();
        login("vlina7078@yahoo.com", "te$t$tudent");
        createNewPlayList();
        Assert.assertTrue(confirmPlaylistCreated(),"New playlist created");
        renamePlaylist();
        Assert.assertTrue(confirmPlaylistExists(),"Playlist renamed");
    }

    //Methods

    public void createNewPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//i[@title='Create a new playlist']"))).click();
        WebElement newPlaylist = myDriver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();
        WebElement nameField = myDriver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li/a[text()='" + playlistName + "']")));
        testPlaylist.click();
        System.out.println("");
    }

    private WebElement editingField(){
        By editLocator = By.xpath("//*[@data-testid='inline-playlist-name-input']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editLocator));
        return myDriver.findElement(editLocator);
    }

    public void renamePlaylist() {
       WebElement playList = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(topPlaylist)));
        Actions actions = new Actions(myDriver);
        actions.doubleClick(playList).perform();
        editingField().sendKeys(Keys.CONTROL+"A");
        editingField().sendKeys(newName);
        editingField().sendKeys(Keys.RETURN);
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='success show' and contains(text(),'"+newName+"')]")));
    }

    public boolean confirmPlaylistCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li/a[text()='" + playlistName + "']")));
        return true;
    }
    public boolean confirmPlaylistExists() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li/a[text()='" + newName + "']")));
        return true;
    }

}
