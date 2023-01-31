import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    static WebDriver driver;
    static String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebElement getSuccessBanner() {
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        return successBanner;
    }

    public void openUserProfile() {
        WebElement profile = driver.findElement(By.cssSelector(".view-profile"));
        profile.click();
    }

    public String getUsername() {
        String userName = driver.findElement(By.cssSelector(".view-profile .name")).getText();
        return userName;
    }

    public void setName(String newName) {
        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(newName);
    }

    public void setPassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent");
    }

    public void saveProfile() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }
}
