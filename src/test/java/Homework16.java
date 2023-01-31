import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16  extends BaseTest {
    @Test
    public static void RegistrationNavigation () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);

        WebElement RegistrationSubmit = driver.findElement(By.cssSelector("[id='hel']"));
        RegistrationSubmit.click();

        WebElement Register = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(Register.isDisplayed());

        driver.quit();
    }
}


