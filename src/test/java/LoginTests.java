import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest() {

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public static void LoginSucceedTest() {

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys("demo@class.com");
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent");
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar")));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }

    @Test
    public static void LoginWrongPasswordTest() {

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys("demo@class.com");
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys("student");
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        driver.quit();
    }

    @Test
    public static void LoginEmptyPasswordTest() {

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys("demo@class.com");
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hel")));
        Assert.assertTrue(registationLink.isDisplayed(), "==== Registation link displayed ====");
        driver.quit();
    }

    @Test
    public static void LoginWrongEmailTest() {

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys("dem@class.com");
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent");
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hel")));
        String link = registationLink.getText();
        System.out.println("==== This is our link text ==== " + link);
        driver.quit();
    }
}