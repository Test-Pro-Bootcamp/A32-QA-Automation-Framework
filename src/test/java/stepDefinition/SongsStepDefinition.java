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

public class SongsStepDefinition {

    @And("I open AllSongs page for Songs")
    public void iOpenAllSongsPageSongs() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.goToAllSongs();
    }
    @And("I click on All shuffle button")
    public void iClickOnAllShuffleButton() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongsPage.allShuffle();
    }
    @Then("Song is playing")
    public void songIsPlaying() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }
    @And("I double click on first song")
    public void iDoubleClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongsPage.doubleClickSong();
    }
    @And("I right click on first song")
    public void iRightClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongsPage.rightClickSong();
    }
    @And("I select Play")
    public void iSelectPlay() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongsPage.playBtnClick();
    }
    @And("I click on search field")
    public void iClickOnSearchField() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.clickSearchField();
    }
    @And("I enter name of song and click ENTER")
    public void iEnterNameOfSong() throws InterruptedException {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.enterSearchSong("Pluto");
        Thread.sleep(2000);
    }

    @Then("I see Title of search results")
    public void iSeeTitleOfSearchResults() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.showSearchResultTitle());
    }
}
