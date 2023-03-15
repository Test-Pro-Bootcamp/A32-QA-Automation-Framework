package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before //("I open browser")
    public void iOpenBrowser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5),Duration.ofMillis(200));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://testpro.io/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
    }

    @And("I submit")
    public void iSubmit() {
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
    }
}
