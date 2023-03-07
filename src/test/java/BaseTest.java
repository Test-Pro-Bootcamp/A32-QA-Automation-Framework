import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.annotation.Contract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;


public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    public String url = "https://bbb.testpro.io";
    Actions actions;
    ThreadLocal<WebDriver> threadDriver;

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

    @BeforeMethod
    public void setUpBrowser() throws  MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    public WebDriver getThreadDriver() {
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username ="darina.tagirs";
        String accessKey ="8zzSymKEsXg5Npz2lCrh9w16wvQ4sWdnTWZy0tYnogd7hMc9c9";
        String hub ="@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        //My capabilities
        caps.setCapability("platform", "Windows 1o");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "106.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), caps);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://172.27.128.1:4444";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver = new FirefoxDriver();
            case "edge":
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();

        }
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}

