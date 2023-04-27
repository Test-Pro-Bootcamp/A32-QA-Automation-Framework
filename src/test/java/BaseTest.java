import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObject.LoginPage;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public String url = "https://bbb.testpro.io/";
    ThreadLocal <WebDriver> threadDriver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        // driver.manage().window().maximize();
        driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.get(url);
    }
    public WebDriver getDriver() {
        return threadDriver.get();
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
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName","edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    public void loginSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    public void login(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email,password);
    }
}
