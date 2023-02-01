import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework16 extends BaseTest{

    @Test
    public static void RegistrationNavigationTest(){
         WebDriver currentDriver= new ChromeDriver();
           currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           String url="https://bbb.testpro.io/";
           currentDriver.get(url);

           WebElement registrationInput = currentDriver.findElement(By.cssSelector("#hel"));
           registrationInput.click();
           WebElement registerButton = currentDriver.findElement(By.cssSelector("input[value='Register']"));
           Assert.assertTrue(registerButton.isDisplayed());
           currentDriver.quit();


    }
}
