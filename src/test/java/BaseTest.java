import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public WebDriverWait wait = null;
    public WebDriverWait wait1 = null;
    static WebDriver myDriver;
    ThreadLocal<WebDriver> threadDriver; //parallel testing browser type

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public void setUpBrowser() throws MalformedURLException {
        myDriver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(myDriver);
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
//        wait = new WebDriverWait(getMyDriver(), Duration.ofSeconds(5)); //explicit wait
        wait = new WebDriverWait(getMyDriver(), Duration.ofSeconds(10, 200));
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.37:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
//                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return myDriver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return myDriver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browser name","firefox");
                return myDriver = new RemoteWebDriver(URI.create(gridURL).toURL(),capabilities);
            case "grid-chrome":
                capabilities.setCapability("browser name","chrome");
                return myDriver = new RemoteWebDriver(URI.create(gridURL).toURL(),capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return myDriver = new ChromeDriver();
        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String userName = "goldcluster999";
        String authkey = "odo6dOvU750TquQXWXMxnmszSsk4e0VrMoJ1oIe9W03pe6iUzG";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platform", "Windows 10");
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("version", "110.0");
        desiredCapabilities.setCapability("resolution", "1024x768");
        desiredCapabilities.setCapability("build", "TestNG With Java");
        desiredCapabilities.setCapability("name", this.getClass().getName());
        desiredCapabilities.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + userName + ":" + authkey + hub), desiredCapabilities);
    }

    public static WebDriver getMyDriver() {
        return myDriver;
    }

    public WebDriver getThreadDriver() {    // Creating a method to return driver for parallel testing
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        myDriver.quit();
    }

    //Creating Helper Methods


    protected static void openLoginUrl() {
        String url = "https://bbb.testpro.io/";
        myDriver.get(url);
        myDriver.manage().window().maximize();
    }

    protected void enterEmail(String email) {
        WebElement emailField = myDriver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {
        WebElement passwordField = myDriver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitButton = myDriver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
