package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions extends BaseDefinition {
    WebDriver driver;
    WebDriverWait wait;

//    Login Success

    @Given("I open Login Page")
    public void openLoginPage() { BaseDefinition.driver.get("https://bbb.testpro.io");
    }
    @When("I enter valid email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter valid password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //    Login with non-existing email
    @When("I enter non-existing email {string}")
    public void iEnterNonExistingEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @Then("I am still on the login page")
    public void iAmStillOnTheLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @And("I enter non-existing password {string}")
    public void iEnterNonExistingPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @When("I enter empty email {string}")
    public void iEnterEmptyEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter empty password {string}")
    public void iEnterEmptyPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoutButton();
    }

    @Then("I am logged out")
    public void iAmLoggedOut() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
}