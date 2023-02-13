import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void LoginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideLoginSucceed();
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public static void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void LoginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("ksenia.strigkova@gmail.com");
        loginPage.providePassword("te$t123");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());

    }

    @Test
    public static void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("ksenia.strigkova@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void LoginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("ksenia.strigkova@gmail.c");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}
