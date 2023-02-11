import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void addPlaylist() {
        enterEmail("kamilakk@bk.ru");
        enterPassword("te$t$tudent");
        loginSubmit();
        buttonPlaylist();
        newPlaylist();
        createNewPlaylist("NewPlaylist1");
    }

    @Test
    public void renamePlaylist() {
        Actions action = new Actions(driver);
        enterEmail("kamilakk@bk.ru");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement findPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']/a[@href][@data-v-e75e0fde][contains(text(),'NewPlaylist1')]"));
        action.moveToElement(findPlaylist).perform();
        action.contextClick(findPlaylist).perform();
        WebElement editPlayList = driver.findElement(By.xpath("//*[text()='Edit']"));
        editPlayList.click();
        WebElement editPlaylistName = driver.findElement(By.cssSelector("input[name='name']"));
        editPlaylistName.sendKeys((Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE)));
        editPlaylistName.sendKeys("NewReNamePlaylist");
        editPlaylistName.sendKeys(Keys.ENTER);
        findReNamePlaylist();
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
    public void findReNamePlaylist(){
        WebElement findRePlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']/a[@href][@data-v-e75e0fde][contains(text(),'NewReNamePlaylist')]"));
        Assert.assertTrue(findRePlaylist.isDisplayed());
    }
    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void buttonPlaylist(){
        WebElement selectButtonPlaylist = driver.findElement(By.xpath("//i[@class='fa fa-plus-circle create']"));
        selectButtonPlaylist.click();
    }
    public void newPlaylist(){
        WebElement selectNewPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        selectNewPlaylist.click();
    }
    public void createNewPlaylist(String newName){
        WebElement addNewPlaylist = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']/input[@placeholder]"));
        addNewPlaylist.click();
        addNewPlaylist.sendKeys(newName);
        addNewPlaylist.sendKeys(Keys.ENTER);
    }

}

