import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends  BaseTest{
    @Test
    public void successLogin() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("rumkostia92@gmail.com")
        .enterPassword("te$t$tudent")
        .loginSubmit();
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }
}
