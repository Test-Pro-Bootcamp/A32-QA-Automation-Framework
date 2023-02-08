import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        setupClass();
        setUpBrowser("https://bbb.testpro.io/");
        enterEmail("burkovads@mail.ru");
        enterPassword("Julka@0721");
        loginSubmit();
        allSongsList();
        songReactorInAllSongs();
        addTo();
        favoritesInAddToo();
        favoritesPlaylist();
        songReactorInFavorite();
        tearDown();
    }
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }
    public void allSongsList() {
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }
    public void songReactorInAllSongs() {
        WebElement songReactor = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[12]/td[2]"));
        songReactor.click();
    }
    public void addTo() {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
    }
    public void favoritesInAddToo() {
        WebElement favorites = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[4]"));
        favorites.click();
    }
    public void favoritesPlaylist() {
        WebElement favoritesPlaylist = driver.findElement(By.cssSelector(".playlist.favorites"));
        favoritesPlaylist.click();
    }
    public void songReactorInFavorite() {
        WebElement songReactorInFavorite = driver.findElement(By.xpath("//*[@id=\"favoritesWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        Assert.assertTrue(songReactorInFavorite.isDisplayed());
    }
}
