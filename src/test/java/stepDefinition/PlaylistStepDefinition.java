package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.AllSongsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PlaylistPage;

public class PlaylistStepDefinition extends BaseDefinition {

    WebDriver driver;

    @Given("I open Login Page")
    public void openLoginPagePlaylist() {
        getThreadLocal().get("https://bbb.testpro.io");
    }
    @When("I login success")
    public void iLoginSuccessPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.login();
    }
    @And("I click on plus-button")
    public void iClickOnPlusButton() {
        HomePage homePage =new HomePage(getThreadLocal());
        homePage.createPlaylistButton();
    }
    @And("I select create new playlist")
    public void iSelectCreateNewPlaylist() {
        HomePage homePage =new HomePage(getThreadLocal());
        homePage.newPlaylistCreate();
    }
    @And("I enter a name of Playlist and click ENTER")
    public void iEnterANameOfPlaylist() {
        HomePage homePage =new HomePage(getThreadLocal());
        String createdPlaylistName = "Actual";
        homePage.enterNewPlaylistName(createdPlaylistName);
    }
    @Then("I get notification 'Created playlist'")
    public void iGetNotificationCreated() {
        String notifyCreatedPlaylist = "Created playlist";
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertTrue(homePage.showSuccessBanner(notifyCreatedPlaylist));
    }
    @And("I open AllSongs page")
    public void iOpenAllSongsPagePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.goToAllSongs();
    }
    @And("I select the first song")
    public void iSelectTheFirstSongAllSongs() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.selectFirstSong();
    }
    @And("I click on AddTo button")
    public void iClickOnAddToButtonAllSongs() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.clickAddToButton();
    }
    @And("I select the first playlist")
    public void iSelectTheFirstPlaylist() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.selectFirstPlaylist();
    }
    @Then("I get notification")
    public void iGetNotificationPlaylist() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        Assert.assertTrue(allSongsPage.showNotification());
    }
    @And("I click on playlist")
    public void iClickOnPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.clickPlaylist();
    }
    @And("I delete a song by DELETE keyboard")
    public void iDeleteASongByDELETEKeyboard() {
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        playlistPage.deleteFirstSong();
    }
    @Then("I get notificationEmptyList")
    public void iGetNotificationEmptyList() {
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        Assert.assertTrue(playlistPage.showTextNotification());
    }
    @And("I double click on playlist")
    public void iDoubleClickOnPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.doubleClickSelectedPlaylist();
    }
    @And("I enter a new name of playlist and click ENTER")
    public void iEnterANewNameOfPlaylist() {
        String newPlaylistName = "Winter";
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.enterPlaylistName(newPlaylistName);
    }
    @Then("I get notificationRenamePlaylist {string}")
    public void iGetNotificationRenamePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        String notifyUpdatedPlaylist = "Updated playlist";
        Assert.assertTrue(homePage.showSuccessBanner(notifyUpdatedPlaylist));
    }
    @And("I click on red delete-button")
    public void iClickOnRedDeleteButton() {
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        playlistPage.deletePlaylist();
    }
    @Then("I get notificationDeletedPlaylist {string}")
    public void iGetNotificationDeletePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        String notifyDeletedPlaylist = "Deleted playlist";
        Assert.assertTrue(homePage.showSuccessBanner(notifyDeletedPlaylist));
    }
}
