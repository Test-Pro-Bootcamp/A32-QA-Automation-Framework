import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickProfileName();
        profilePage.chooseColorTheme();
        Assert.assertTrue(profilePage.selectColorActive());
    }

    @Test
    public void changeProfileName() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickProfileName();
        profilePage.clickInputProfileName()
                .enterNewProfileName("Student2023")
                .clickInputCurrentPassword()
                .inputCurrentPassword("te$t$tudent")
                .clickSave();
        Assert.assertTrue(homePage.notificationText());
    }
}
