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
    public void openLoginPage() { BaseDefinition.driver.get("https://bbb.testpro.io");
    }
    @When("I login success")
    public void iLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
    @And("I open AllSongs page")
    public void iOpenAllSongsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToAllSongs();
    }

    @And("I click on All shuffle button")
    public void iClickOnAllShuffleButton() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.allShuffle();
    }

    @Then("Song is playing")
    public void songIsPlaying() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        Assert.assertTrue(allSongsPage.barIsDisplayed());
    }

    @And("I double click on first song")
    public void iDoubleClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.doubleClickSong();
    }

    @And("I right click on first song")
    public void iRightClickOnFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.rightClickSong();
    }

    @And("I select Play")
    public void iSelectPlay() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.playBtnClick();
    }

    @And("I click on search field")
    public void iClickOnSearchField() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchField();
    }

    @And("I enter name of song and click ENTER")
    public void iEnterNameOfSong() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchSong("Pluto");
    }


}
