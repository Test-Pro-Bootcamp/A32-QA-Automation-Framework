import PageFolder.KoelHomePage;
import PageFolder.KoelLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public String url = "https://bbb.testpro.io/";
    ThreadLocal<WebDriver> threadDriver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("givenBrowser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(url);
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String userName = "demarcuspro";
        String authKey = "qN6PChU1tIb6Vst1wLzRUaKOS7nRy4zGuB1RCrYfsFB8L6X3Xs";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platform", "Windows 10");
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("version", "106.0");
        desiredCapabilities.setCapability("resolution", "1024x768");
        desiredCapabilities.setCapability("build", "TestNG With Java");
        desiredCapabilities.setCapability("name", this.getClass().getName());
        desiredCapabilities.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey + hub), desiredCapabilities);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.0.0.179:4444";
        switch (browser) {
            case "firefox":
                System.getProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "edge":
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();
        }
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}