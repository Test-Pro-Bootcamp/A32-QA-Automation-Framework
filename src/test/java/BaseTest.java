import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {
    public WebDriverWait wait = null;
    public WebDriverWait wait1 = null;
    static WebDriver myDriver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod

    public void setUpBrowser(){
        myDriver = new ChromeDriver();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
        wait = new WebDriverWait(getMyDriver(), Duration.ofSeconds(3)); //explicit wait
        wait1 = new WebDriverWait(getMyDriver(), Duration.ofSeconds(5, 200));
    }

    public static WebDriver getMyDriver() {
        return myDriver;
    }

    @AfterMethod
    public void tearDown(){
        myDriver.quit();
    }
    //Creating Helper Methods
    protected static void openLoginUrl() {
        String url="https://bbb.testpro.io/";
        myDriver.get(url);
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
