import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.PageLoadStrategy;


public class BaseTest {

    static WebDriver driver;
    static String url = "https://bbb.testpro.io/";

    public static void loginKoel() {

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys("dashazhyrkova@gmail.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent28");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public static void navigateToAllSongs() {
        WebElement navigateToAllSongsPage = driver.findElement(By.xpath("//a[@href='#!/songs']"));
        navigateToAllSongsPage.click();
    }

    public static void songDoubleClick() {
        Actions act = new Actions(driver);
        WebElement songDoubleClick = driver.findElement(By.cssSelector("[class='song-item']"));
        act.doubleClick(songDoubleClick).perform();
    }

    public static void songIsPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songIsPlaying.isDisplayed());
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


