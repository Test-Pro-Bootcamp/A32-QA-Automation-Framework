import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActionsTests extends BaseTest {

    @Test
    public void playSongTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        homePage.goToAllSongs();
        allSongsPage.allShuffle();
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }

    @Test
    public void renamePlaylist() {
        String playlistName = "Summer songs";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.login("burkovads@mail.ru", "Julka@0721");
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }


    @Test
    public void playSongFromListTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage allSongsPage = new HomePage(driver);
        loginPage.login("burkovads@mail.ru", "Julka@0721");
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }
}
