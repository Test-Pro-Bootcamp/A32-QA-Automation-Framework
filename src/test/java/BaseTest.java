import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String url = BaseURL;
        driver.get(url);
    }
    public WebDriver getDriver(){
        return threadDriver.get();
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://10.0.0.117:4444";
        switch (browser){
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName","edge");
                return new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
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
