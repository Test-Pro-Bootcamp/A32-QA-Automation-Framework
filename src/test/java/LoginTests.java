import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void LoginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());

        loginPage.provideLoginSucceed();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public  void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public  void LoginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("te$t123")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public  void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.com")
                .providePassword("")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public  void LoginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("ksenia.strigkova@gmail.c")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}