package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.SongsPage;

public class SongsStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I open Page")
    public void openLoginPage() {
        BaseDefinition.getThreadLocal().get("https://bbb.testpro.io/");
    }

    @When("I login success")
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideLoginSucceed();
    }

    @And("I open Songs Page")
    public void openSongsPage() {
        SongsPage songsPage = new SongsPage(BaseDefinition.getThreadLocal());
        songsPage.clickAllSongs();
    }

    @And("I click on first song")
    public void clickOnFirstSong() {
        SongsPage songsPage = new SongsPage(BaseDefinition.getThreadLocal());
        songsPage.chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();
    }

    @Then("Song is playing")
    public void songIsPlaying() {
        SongsPage songsPage = new SongsPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }
}