import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    @BeforeSuite
    @Parameters("baseUrl")
    public void setUpBrowser(String baseUrl){
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public static void logIn (String email, String password) {
        WebDriver driver = new ChromeDriver();
        WebElement emailfield = driver.findElement(By.cssSelector("[type='email']"));
        emailfield.sendKeys(email);
        WebElement passwordfield = driver.findElement(By.cssSelector("[type='password']"));
        passwordfield.sendKeys(password);
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();
    }




}
