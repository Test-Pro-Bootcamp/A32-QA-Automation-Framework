package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

import java.time.Duration;

public class SongsStepDefinition {

    WebDriver driver;
    WebDriverWait wait;



    @Given("I login success")
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideLoginSucceed();
    }

    @And("I open Songs Page")
    public void openSongsPage() {
        SongsPage songsPage = new SongsPage(driver);
        songsPage.clickAllSongs();
    }

    @When("I click on first song")
    public void clickOnFirstSong() {
        SongsPage songsPage = new SongsPage(driver);
        songsPage.chooseAllSongList()
                .contextClickFirstSong()
                .choosePlay();
    }

    @Then("Song is playing")
    public void songIsPlaying() {
        SongsPage songsPage = new SongsPage(driver);
        Assert.assertTrue(songsPage.getProgressBar().isDisplayed());
    }

}
