package StepDefenition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {
     private WebDriver driver;
    private WebDriverWait wait;
    @Given("I open browser")
    public void iOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @And("I open Login page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }
    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);

    }
    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSubmit();
    }
    @Then("I logged in")
    public void iLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(homePage.getAvatar())).isDisplayed());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(loginPage.getButton())).isDisplayed());

    }
}
