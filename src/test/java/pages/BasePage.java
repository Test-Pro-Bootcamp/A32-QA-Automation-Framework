package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BasePage {
     public static WebDriver driver;
     public static WebDriverWait wait;
     public static Actions actions;
    public BasePage(WebDriver setDriver){
        driver=setDriver;
        actions=new Actions(driver);
        wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }
    public void doubleClick(WebElement element){
        actions.doubleClick(element).perform();
    }


}



//        Email("demo@class.com");
//        Password("te$t$tudent");
