package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;


    @Given("I open Login Page")
    public void openLoginPage() {
        BaseDefinition.getThreadLocal().get("https://bbb.testpro.io/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void submit() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.clickSubmitBtn();

    }

    @Then("I am logged in")
    public void loggedIn() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @And("I enter incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
    }

    @Then("I still Login page")
    public void stillLoginPage() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());

    }

    @When("I enter Not existing email {string}")
    public void enterNotExistingEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }

    @When("I enter Empty email {string}")
    public void enterEmptyEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }

    @And("I enter Empty password {string}")
    public void enterEmptyPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }
}