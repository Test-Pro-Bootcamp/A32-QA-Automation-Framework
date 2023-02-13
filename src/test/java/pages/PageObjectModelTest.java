package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectModelTest extends BasePage {
    @Test
    public void successLogin(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("rumkostia92@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.loginSubmit();
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.enterEmail("rumkostia92@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.loginSubmit();
        homePage.enterPlaylist();
        homePage.changePlaylistName("waflio");
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
    @Test
    public void deletePlaylist()  {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.enterEmail("rumkostia92@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.loginSubmit();
        homePage.deleteActions();
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
    @Test
    public void createPlaylist(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.enterEmail("rumkostia92@gmail.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.loginSubmit();
        homePage.createNewPlaylist();
        homePage.setPlaylistName("Papa");
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}
