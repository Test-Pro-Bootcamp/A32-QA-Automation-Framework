import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest {
    @Test
    public static void RegistrationNavigation() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement RegistrationLink = driver.findElement(By.xpath("//*[@id='hel']"));
        RegistrationLink.click();
        WebElement registrationField = driver.findElement(By.xpath("//*[@id='email']"));
        Assert.assertTrue(registrationField.isDisplayed());
        driver.quit();
    }
}
