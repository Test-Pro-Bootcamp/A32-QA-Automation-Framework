import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public static void createPlaylist() {
        login("ksenia.strigkova@gmail.com", "te$t$tudent");
        addPlaylist();
        selectPlaylist();
        enterNamePlaylist();
        assertNotificationText();
    }

    @Test
    public static void renamePlaylist() {

        login("ksenia.strigkova@gmail.com", "te$t$tudent");
        doubleClickOnPlaylist();
        enterNewNamePlaylist("blabla22");
        assertRenamePlaylist();
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
        inputName.sendKeys("lalala666");
        inputName.sendKeys(Keys.ENTER);
    }

    public static boolean assertNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success"))).isDisplayed();}

    private static void doubleClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("lalala666")));
        new Actions(driver)
                .doubleClick(playlist)
                .perform();
    }

    public static void enterNewNamePlaylist(String name) {
        WebElement inputPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        inputPlaylistName.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        inputPlaylistName.sendKeys(Keys.ENTER);
    }

    public static void assertRenamePlaylist() {
        WebElement newNamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("blabla22")));
        Assert.assertTrue(newNamePlaylist.isDisplayed());
    }
}

