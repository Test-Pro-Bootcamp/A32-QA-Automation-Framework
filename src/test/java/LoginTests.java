import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("burkova@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("burkova@mail.ru")
                .providePassword("Julka")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }
    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmitBtn();
        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }
    @Test
    public void logOutTest() {
        HomePage homePage = new HomePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.login();
        homePage.clickLogoutButton();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
}
