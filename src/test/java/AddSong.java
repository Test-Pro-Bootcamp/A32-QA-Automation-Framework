import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class AddSong extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        enterEmail("rumkostia92@gmail.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        addSongToAlbum();
        checkSongInAlbum();

    }

    public void addSongToAlbum() {
        Actions action = new Actions(driver);
        WebElement song = driver.findElement(By.cssSelector("ol[class='top-song-list'] > li:nth-child(3) > article > span[class='cover']"));
        action.contextClick(song).perform();
        WebElement addButton = driver.findElement(By.cssSelector("[class='has-sub']"));
        addButton.click();
        WebElement menuAlbum = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']/li[contains(text(),'ZXC234')]"));
        menuAlbum.click();

    }

    public void checkSongInAlbum() {
        WebElement homeAlbum = driver.findElement(By.cssSelector("[href='#!/playlist/33111']"));
        homeAlbum.click();
        WebElement albumSong = driver.findElement(By.xpath("//tr/td[contains(text(),'Tunnel of Lights (ID 1689)')]"));
        Assert.assertTrue(albumSong.isDisplayed(), "Yes sir");
    }





}
