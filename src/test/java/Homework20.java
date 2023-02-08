import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public static void createPlaylist() {
        enterEmail("ksenia.strigkova@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        addPlaylist();
        selectPlaylist();
        enterNamePlaylist();
        notificationText();
    }

    @Test
    public static void deletePlaylist() {

        enterEmail("ksenia.strigkova@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        clickMyPlaylist();
        deleteMyPlaylist();
        notificationText();
    }

    public static void addPlaylist() {
        WebElement btnAddPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-plus-circle")));
        btnAddPlaylist.click();
    }

    public static void selectPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"))).click();
    }

    public static void enterNamePlaylist() {
        WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        inputName.click();
        inputName.clear();
        inputName.sendKeys("ksenia123");
        inputName.sendKeys(Keys.ENTER);
    }

    public static void notificationText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
    }

    public static void clickMyPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*=\"playlist\"]")));
        playlist.click();
    }

    public static void deleteMyPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist"))).click();
    }
}