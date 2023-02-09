import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest{
    @Test
    public void renamePlaylist() {
        enterEmail("rumkostia92@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        enterPlaylist();
        changePlaylistName();
    }
    public void enterPlaylist(){
        WebElement playlist = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();

    }
    public void changePlaylistName(){
        WebElement playlistField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        playlistField.sendKeys(Keys.CONTROL + "a");
        playlistField.sendKeys(Keys.DELETE);
        playlistField.sendKeys("ABCrv", Keys.ENTER);
        WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='success show']")));
    }











}
