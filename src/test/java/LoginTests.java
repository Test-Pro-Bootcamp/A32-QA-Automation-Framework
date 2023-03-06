import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("te$t123")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("ksenia.strigkova@gmail.c")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void logOut() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        loginPage.clicklogOut();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}