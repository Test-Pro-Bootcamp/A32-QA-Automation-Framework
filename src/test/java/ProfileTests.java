import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;

public class ProfileTests extends BaseTest {


    @Test
    public void changeProfileNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        String user = profilePage.generateRandomName();

        loginPage.login();
        homePage.openUserProfile();
        profilePage.setName(user)
                .setPassword("Julka@0721")
                .saveProfile();
        homePage.successBanner();
        Assert.assertEquals(profilePage.getUsername(), user);
    }
    @Test
    public void changeColorTheme() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        homePage.openUserProfile();
        profilePage.chooseTheme();
        Assert.assertTrue(profilePage.checkSelectedThemeColor());
    }
    @Test
    public void chooseCheckboxNotify() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        homePage.openUserProfile();
        profilePage.selectCheckboxNotify();
        Assert.assertTrue(profilePage.checkSelectedCheckboxNotify());
    }
}
