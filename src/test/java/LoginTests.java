import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public static void loginEmptyEmailPasswordTest () {

        String url = "https://testpro.io/";
        myDriver.get(url);
        Assert.assertEquals(myDriver.getCurrentUrl(), url);

    }

    @Test(description = "Login with valid credentials")
    public void loginValidEmailValidPasswordTest(){
        openLoginUrl();
        enterEmail("vlina7078@yahoo.com");
        enterPassword("te$t$tudent");
        clickSubmit();
// Assert
       WebElement searchField = myDriver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
       Assert.assertTrue(searchField.isDisplayed());
    }


}
