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

public class LoginStepDefinitions {
    @Given("I open Login Page")
    public void openLoginPageLogin() { BaseDefinition.getThreadLocal().get("https://bbb.testpro.io");
    }
    @When("I enter valid email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }
    @And("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.clickSubmitBtn();
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @When("I enter non-existing email {string}")
    public void iEnterNonExistingEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }
    @Then("I am still on the login page")
    public void iAmStillOnTheLoginPage() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
    @And("I enter non-existing password {string}")
    public void iEnterNonExistingPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }
    @When("I enter empty email {string}")
    public void iEnterEmptyEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }
    @And("I enter empty password {string}")
    public void iEnterEmptyPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }
    @Given("I login success")
    public void iLoginSuccess() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.login();
    }
    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.clickLogoutButton();
    }
    @Then("I am logged out")
    public void iAmLoggedOut() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(loginPage.registrationLink().isDisplayed());
    }
}
