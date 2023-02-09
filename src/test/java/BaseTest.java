import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static java.lang.Thread.*;


public class BaseTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static String url = "https://bbb.testpro.io/";
    static String urlHome = "https://bbb.testpro.io/#!/home";


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
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" [type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public static void loginSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[type='submit']"))).click();
    }

    public static void login(String email, String password) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" [type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[type='submit']"))).click();
    }
}