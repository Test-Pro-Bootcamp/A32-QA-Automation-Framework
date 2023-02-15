
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTestRefactored extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(myDriver);
        MainPage homePage = new MainPage(myDriver);
        openLoginUrl();
        loginPage.login();
        Assert.assertTrue(homePage.findSearchField());
    }


}
