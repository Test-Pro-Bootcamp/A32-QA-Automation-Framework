package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;

public class PlaylistStepDefinition extends BaseDefinition {

    WebDriver driver;

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io");
    }
    @When("I login success")
    public void iLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
    @And("I click on plus-button")
    public void iClickOnPlusButton() {
        HomePage homePage =new HomePage(driver);
        homePage.createPlaylistButton();
    }
    @And("I select create new playlist")
    public void iSelectCreateNewPlaylist() {
        HomePage homePage =new HomePage(driver);
        homePage.newPlaylistCreate();
    }
    @And("I enter a name of Playlist and click ENTER")
    public void iEnterANameOfPlaylist() {
        HomePage homePage =new HomePage(driver);
        String createdPlaylistName = "Actual";
        homePage.enterNewPlaylistName(createdPlaylistName);
    }
    @Then("I get notification 'Created playlist'")
    public void iGetNotificationCreated() {
        String notifyCreatedPlaylist = "Created playlist";
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.showSuccessBanner(notifyCreatedPlaylist));
    }
    @And("I open AllSongs page")
    public void iOpenAllSongsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToAllSongs();
    }
    @And("I select the first song")
    public void iSelectTheFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.selectFirstSong();
    }
    @And("I click on AddTo button")
    public void iClickOnAddToButton() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.clickAddToButton();
    }
    @And("I select the first playlist")
    public void iSelectTheFirstPlaylist() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.selectFirstPlaylist();
    }
    @Then("I get notification")
    public void iGetNotification() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        Assert.assertTrue(allSongsPage.showNotification());
    }
    @And("I click on playlist")
    public void iClickOnPlaylist() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPlaylist();
    }
    @And("I delete a song by DELETE keybord")
    public void iDeleteASongByDELETEKeybord() {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.deleteFirstSong();
    }
    @Then("I get notification {string}")
    public void iGetNotificationRemovedSong() {
        HomePage homePage = new HomePage(driver);
        String notifyRemovedSong = "Removed 1 song from";
        Assert.assertTrue(homePage.showSuccessBanner(notifyRemovedSong));
    }
    @And("I double click on playlist")
    public void iDoubleClickOnPlaylist() {
        HomePage homePage = new HomePage(getDriver());
        homePage.doubleClickSelectedPlaylist();
    }
    @And("I enter a new name of playlist and click ENTER")
    public void iEnterANewNameOfPlaylist() {
        String newPlaylistName = "Winter";
        HomePage homePage = new HomePage(getDriver());
        homePage.enterPlaylistName(newPlaylistName);
    }
    @Then("I get notification {string}")
    public void iGetNotificationRenamePlaylist() {
        HomePage homePage = new HomePage(driver);
        String notifyUpdatedPlaylist = "Updated playlist";
        Assert.assertTrue(homePage.showSuccessBanner(notifyUpdatedPlaylist));
    }
    @And("I click on red delete-button")
    public void iClickOnRedDeleteButton() {
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        playlistPage.deletePlaylist();
    }
    @Then("I get notification {string}")
    public void iGetNotificationDeletePlaylist() {
        HomePage homePage = new HomePage(getDriver());
        String notifyDeletedPlaylist = "Deleted playlist";
        Assert.assertTrue(homePage.showSuccessBanner(notifyDeletedPlaylist));
    }
}
