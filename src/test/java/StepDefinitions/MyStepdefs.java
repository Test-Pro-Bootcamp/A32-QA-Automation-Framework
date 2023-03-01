package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyStepdefs {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 @Before
 public void iOpenBrowser(){
     driver = new ChromeDriver();
     wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 }

 @After
 public void tearDown(){
    driver.quit();
 }
    @Given("I open login page")
    public void iOPenLoginPage(){
        driver.get(driver.getCurrentUrl());
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }


    @Then("Im logged in")
    public void imLoggedIn() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        wait();
        Assert.assertTrue(homePage.barIsDisplayed());
    }
}
