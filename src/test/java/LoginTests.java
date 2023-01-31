import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void LoginSucceedTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void LoginWrongPasswordTest() {
        enterEmail("demo@class.com");
        enterPassword("student");
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void LoginEmptyPasswordTest() {
        enterEmail("demo@class.com");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = driver.findElement(By.id("hel"));
        Assert.assertTrue(registationLink.isDisplayed(), "==== Registation link displayed ====");
    }

    @Test
    public void LoginWrongEmailTest() {
        enterEmail("dem@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = driver.findElement(By.id("hel"));
        String link = registationLink.getText();
        System.out.println("==== This is our link text ==== " + link);
    }

    @Test
    public void changeProfileNameTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        openUserProfile();
        String user = generateRandomName();
        setName(user);
        setPassword();
        saveProfile();
        getSuccessBanner();
        Assert.assertEquals(getUsername(), user);
    }


}
//        Email("demo@class.com");
//        Password("te$t$tudent");