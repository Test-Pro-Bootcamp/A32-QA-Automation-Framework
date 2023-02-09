import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;



public class BaseTest {

    static WebDriver driver;
   static WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String url=BaseURL;
        driver.get(url);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    public void loginSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }
}
//        Email("demo@class.com");
//        Password("te$t$tudent");
