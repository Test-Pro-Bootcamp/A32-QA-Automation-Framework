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

public class SongsStepDefinition extends BaseDefinition {
    WebDriver driver;
    @Given("I open Login Page")
    public void openLoginPageSongs() { BaseDefinition.getThreadLocal().get("https://bbb.testpro.io");
    }
    @When("I login success")
    public void iLoginSuccessSongs() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.login();
    }
    @And("I open AllSongs page")
    public void iOpenAllSongsPageSongs() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.goToAllSongs();
    }
    @And("I click on All shuffle button")
    public void iClickOnAllShuffleButton() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.allShuffle();
    }
    @Then("Song is playing")
    public void songIsPlaying() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }
    @And("I double click on first song")
    public void iDoubleClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.doubleClickSong();
    }
    @And("I right click on first song")
    public void iRightClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.rightClickSong();
    }
    @And("I select Play")
    public void iSelectPlay() {
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        allSongsPage.playBtnClick();
    }
    @And("I click on search field")
    public void iClickOnSearchField() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.clickSearchField();
    }
    @And("I enter name of song and click ENTER")
    public void iEnterNameOfSong() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.enterSearchSong("Pluto");
    }
}
