package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL)  {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        String url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void doubleClick(By locator){
        actions.doubleClick(findElement(locator)).perform();
    }
    public void click(By locator){
        actions.click(findElement(locator)).perform();
    }
    public void sendKeys(By locator,String text){
        actions.sendKeys(findElement(locator),text);
    }
}



//        Email("demo@class.com");
//        Password("te$t$tudent");
