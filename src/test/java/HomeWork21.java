import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.*;

public class HomeWork21 extends BaseTest {
    @Test
    //double click
    public void renamePlaylist() {
        login("burkovads@mail.ru", "Julka@0721");
        userPlaylist();
        enterNameOfPlaylist("By DoubleClick");
        succeedRenamePlaylist();
    }
    public void userPlaylist() {
        Actions action = new Actions(driver);
        WebElement userPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)>a")));
        action.doubleClick(userPlaylist).perform();
    }
    public void enterNameOfPlaylist(String newName) {
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        inputField.sendKeys(CONTROL, "a", BACK_SPACE);
        inputField.sendKeys(newName);
        inputField.sendKeys(ENTER);
    }

    public void succeedRenamePlaylist() {
        WebElement successBaner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        Assert.assertTrue(successBaner.isDisplayed());
    }

    //click Edit
    @Test
    public void renamePlaylistByEdit() {
        login("burkovads@mail.ru", "Julka@0721");
        userPlaylistRightClick();
        clickEdit();
        enterNameOfPlaylist("By Edit");
        succeedRenamePlaylist();
    }
    public void userPlaylistRightClick () {
        Actions action = new Actions(driver);
        WebElement userPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)>a")));
        action.contextClick(userPlaylist).perform();
    }
    public void clickEdit() {
        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menu.playlist-item-menu > ul > li:nth-of-type(1)")));
        edit.click();
    }
}
