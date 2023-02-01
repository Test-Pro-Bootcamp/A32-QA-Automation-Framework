import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework16 extends BaseTest{

    @Test
    public static void registrationNavigationTest(){

        openLoginUrl();

        WebElement registrationInput = myDriver.findElement(By.cssSelector("#hel"));
           registrationInput.click();
           WebElement registerButton = myDriver.findElement(By.cssSelector("input[value='Register']"));
           Assert.assertTrue(registerButton.isDisplayed());

    }
}
