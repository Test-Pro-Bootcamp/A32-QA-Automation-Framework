import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.digests.KeccakDigest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.security.Key;
import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;
    public String url = "https://bbb.testpro.io/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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

    public void logIn(String email, String password){
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
    }
    public void createPlaylist() {
        WebElement createplaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        createplaylist.click();
    }
    public void playlistSelect() {
        WebElement playlistselect = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        playlistselect.click();
    }
    public void enterNameofplaylist() {
        WebElement nameofplaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        nameofplaylist.sendKeys("Shine2");
        nameofplaylist.sendKeys(Keys.ENTER);
    }
    public void usersPlaylist() {
        Actions action = new Actions(driver);
        WebElement userPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)>a")));
        action.doubleClick(userPlaylist).perform();
    }
    public void pressEdit() {
        WebElement editbtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menu.playlist-item-menu > ul > li:nth-of-type(1)")));
        editbtn.click();
    }
    public void renamePlaylist(String newPlaylistName) {
        WebElement renameplaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        renameplaylist.sendKeys(Keys.CONTROL, Keys.BACK_SPACE);
        renameplaylist.sendKeys(newPlaylistName);
        renameplaylist.sendKeys(Keys.ENTER);
    }
}
