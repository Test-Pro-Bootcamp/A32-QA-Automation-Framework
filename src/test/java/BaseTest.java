import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import org.testng.annotations.Optional;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;
    WebDriverWait wait;

    static Actions actions;

   protected static ThreadLocal<WebDriver> threadDriver;

    public String url = "https://bbb.testpro.io/";
    public String urlHome = "https://bbb.testpro.io/#!/home";

    @BeforeMethod
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));

        threadDriver=new ThreadLocal<>();
        threadDriver.set(driver);


        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
       driver.manage().window().maximize();
    }

    public static WebDriver getThreadDriver() {
        return threadDriver.get();
    }

    public WebDriver lambdaTest() throws MalformedURLException{
        String username = "ksenia.strigkova";
        String authkey = "mEL3Wj73VBBHOev61MB5H5WP4IiQ4xnXSBkVWO9qUrHM0RSqfk";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";


        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
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
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}