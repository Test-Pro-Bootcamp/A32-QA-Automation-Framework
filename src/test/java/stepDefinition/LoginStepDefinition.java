package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition extends BaseDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I open browser")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    @And("I open Login Page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
     LoginPage loginPage = new LoginPage(driver);
     loginPage.providePassword(password);
    }

    @And("I submit")
    public void submit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();

    }

    @Then("I am logged in")
    public void loggedIn() {
        HomePage homePage = new HomePage(driver);
        homePage.getUserAvatar();

    }
//    @After
//    public void closeBrowser(){
//        driver.quit();
//    }

    @And("I enter incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @Then("I still Login page")
    public void stillLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getRegistrationLink();

    }

    @When("I enter Not existing email {string}")
    public void eterNotExistingEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @When("I enter Empty email {string}")
    public void enterEmptyEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter Empty password {string}")
    public void enterEmptyPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
}
