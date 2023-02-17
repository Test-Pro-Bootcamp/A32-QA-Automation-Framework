import POM.AllSongsPage;
import POM.HomePage;
import POM.LoginPage;
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
    static WebDriverWait wait;
    public String url = "https://bbb.testpro.io";
    static LoginPage loginpage =new LoginPage(driver);
    static HomePage homepage = new HomePage(driver);
    static AllSongsPage allSongsPage = new AllSongsPage(driver);


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
                .elementToBeClickable(By.cssSelector("[type='submit']")));
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
    public void setUpBrowser() {
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
