import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
        WebElement submitLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));

        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void LoginSucceedTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement avatar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void LoginWrongPasswordTest() {
        enterEmail("demo@class.com");
        enterPassword("student");
        loginSubmit();
        WebElement submitLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void LoginEmptyPasswordTest() {
        enterEmail("demo@class.com");
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hel")));
        Assert.assertTrue(registationLink.isDisplayed(), "==== Registation link displayed ====");
    }

    @Test
    public void LoginWrongEmailTest() {
        enterEmail("dem@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLogin.isDisplayed());

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

    }


}
//        Email("demo@class.com");
//        Password("te$t$tudent");