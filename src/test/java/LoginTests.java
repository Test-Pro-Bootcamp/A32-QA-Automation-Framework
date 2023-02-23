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

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public static void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void LoginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("te$t123")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void LoginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.c")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}
---