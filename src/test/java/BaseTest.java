import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
public class BaseTest {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private  WebDriver getThreadLocal;
    public String url = "https://bbb.testpro.io/";
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
    @BeforeMethod
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser("browser"));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(url);
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is " + getThreadLocal());
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String userName = "burkova0721";
        String authKey = "9JQBuKZzJJUC8sy5TTHjGtdk9C2QQ3RYrxAppSyAXJ1NK90AI9";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platform","Windows 10");
        desiredCapabilities.setCapability("browserName","Chrome");
        desiredCapabilities.setCapability("version","112.0");
        desiredCapabilities.setCapability("resolution","1024x768");
        desiredCapabilities.setCapability("build","TestNG With Java");
        desiredCapabilities.setCapability("name",this.getClass().getName());
        desiredCapabilities.setCapability("plugin","git-testng");
        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey +hub), desiredCapabilities);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.24.184:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return getThreadLocal = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return getThreadLocal = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName","firefox");
                return getThreadLocal = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName","edge");
                return getThreadLocal = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName","chrome");
                return getThreadLocal = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                return getThreadLocal = new ChromeDriver(optionsChrome);
        }
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}
