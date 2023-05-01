import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;

import javax.swing.*;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileNameTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        String user = profilePage.generateRandomName();
        String notifyUpdatedProfile = "Profile updated";
        loginPage.login();
        homePage.openUserProfile();
        profilePage.setName(user)
                .setPassword("Julka@0721")
                .saveProfile();
        homePage.showSuccessBanner(notifyUpdatedProfile);
        Assert.assertEquals(profilePage.getUsername(), user);
    }
    @Test
    public void changeColorTheme() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal()
        );
        loginPage.login();
        homePage.openUserProfile();
        profilePage.chooseTheme();
        Assert.assertTrue(profilePage.checkSelectedThemeColor());
    }
    @Test
    public void chooseCheckboxNotify() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        loginPage.login();
        homePage.openUserProfile();
        profilePage.selectCheckboxNotify();
        Assert.assertTrue(profilePage.checkSelectedCheckboxNotify().is
    }
}
