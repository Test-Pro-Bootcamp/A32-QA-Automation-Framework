import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
public class ActionsTests extends BaseTest {

    @Test
    public void playSongTest() {
        // hover over in clickPlayBtn
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn();
        homePage.goToAllSongs();
        allSongsPage.allShuffle();
        Assert.assertTrue(allSongsPage.barIsDisplayed());

//        // Comparing numbers of elements example
//        List<WebElement> songs = driver.findElements(By.cssSelector("[data-test='song-card']"));
//
//        int songsNumberBefore = songs.size();
//        System.out.println(songsNumberBefore);
//        // Just an example: here we would add or delete an element, but we didn't
//        int songsNumberAfter = songs.size();
//        System.out.println(songsNumberAfter);
//
//        // Soft assert example
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/queue");
//        softAssert.assertTrue(songsNumberBefore == songsNumberAfter,
//                "=== Songs number before should be equal songs number after ===");
//        softAssert.assertAll();
    }

    @Test
    public void renamePlaylist() {
        // double click
        String playlistName = "Summer songs";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login("burkovads@mail.ru", "Julka@0721");
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName(playlistName);
        homePage.SuccessBanner();
    }
    @Test
    public void playSongFromListTest() {
        // right click
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login("burkovads@mail.ru", "Julka@0721");
        homePage.goToAllSongs();
        allSongsPage.choosePlayFromList();
        allSongsPage.playBtnClick();
        allSongsPage.barIsDisplayed();
    }
//    @Test
//    public void countSongsInPlaylist() {
//
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        AllSongsPage allSongsPage = new AllSongsPage(driver);
//        loginPage.login("burkovads@mail.ru", "Julka@0721");
//        homePage.clickOnPlaylist();
//        List<WebElement> songs = driver.findElements(By.cssSelector("#playlistWrapper .song-item"));
//        List<WebElement> song1 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlistWrapper .song-item")));
//        int number = songs.size();
//        Assert.assertEquals(number, 2);
//    }
}
