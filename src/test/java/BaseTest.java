import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BaseTest {
    static WebDriver driver;
    public String url = null;
    static WebDriverWait wait;

    public static void loginKoel() {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys("dashazhyrkova@gmail.com");
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent28");
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public static void navigateToAllSongs() {
        WebElement navigateToAllSongsPage = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='#!/songs']")));
        navigateToAllSongsPage.click();
    }

    public static void songDoubleClick() {
        Actions act = new Actions(driver);
        WebElement songDoubleClick = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[class='song-item']")));
        act.doubleClick(songDoubleClick).perform();
    }
    public static void playlistDoubleClick() {
        Actions actn = new Actions(driver);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistDblClick = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actn.doubleClick(playlistDblClick).perform();
    }
    public static void renamePlaylistName() {
        WebElement playlistRenameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input'")));
        playlistRenameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistRenameInput.sendKeys("My new playlist");
        playlistRenameInput.sendKeys(Keys.ENTER);
    }
    public static void verifyPlaylistRenamed() {
        WebElement myNewPlaylist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[text()='My new playlist']")));
        Assert.assertTrue(myNewPlaylist.isDisplayed());
    }
    public static void songIsPlaying() {
        WebElement songPlaying = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("[alt='Sound bars']")));
        Assert.assertTrue(songPlaying.isDisplayed());
    }
    public static void createNewPlaylist() {
        WebElement createPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        createPlaylist.click();
    }
    public static void selectNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }
    public static void enterPlaylistName() {
        WebElement playlistInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@name='name']")));
        playlistInput.sendKeys("My playlist");
        playlistInput.sendKeys(Keys.ENTER);
    }
    public static void verifyPlaylistCreated() {
        WebElement student = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[text()='My playlist']")));
        Assert.assertTrue(student.isDisplayed());
    }
    public static void selectSong() {
        WebElement song = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//td[@class='title']")));
        song.click();
    }
    public static void addToClick() {
        WebElement addTo = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
    }
    public static void selectPlaylist() {
        WebElement mPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[@class='playlist']")));
        mPlaylist.click();
    }
    public static void open_m_Playlist() {
        WebElement playlist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='m']")));
        playlist.click();
    }
    public static void verifySongIsAdded() {
        WebElement songPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr[2]/td[2]")));
        songPlaylist.click();
        Assert.assertTrue(songPlaylist.isDisplayed());
    }
    public static void openPlaylistPage() {
        WebElement myPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='My playlist']")));
        myPlaylist.click();
    }
    public static void clickDeleteBtn() {
        WebElement playlistDelete = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        playlistDelete.click();
    }
    public static void verifySuccessDeleted() {
        WebElement playlistDelete = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(playlistDelete.isDisplayed());
    }
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    public void loginSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        url = baseURL;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
