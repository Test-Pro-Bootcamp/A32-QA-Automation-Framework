import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("burkova@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("burkova@mail.ru")
                .providePassword("Julka")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void logOutTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickLogoutButton();
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
}
