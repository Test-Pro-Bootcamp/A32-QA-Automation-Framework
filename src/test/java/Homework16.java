import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16  extends BaseTest {
    @Test
    public static void RegistrationNavigation() {
        login();


        WebElement registrationSubmit = driver.findElement(By.cssSelector("[id='hel']"));
        registrationSubmit.click();

        WebElement register = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(register.isDisplayed());

    }

    }


