
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTestRefactored extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getThreadDriver()); //passing ThreadDriver for parallel testing instead of myDriver
        MainPage homePage = new MainPage(getThreadDriver());  //passing ThreadDriver for parallel testing instead of myDriver
        openLoginUrl();
        loginPage.login();
        Assert.assertTrue(homePage.findSearchField());
    }


}
