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

import java.time.Duration;

public class LoginStepDefinitions extends BaseDefinition {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open browser")

    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector()));
    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
    }

    @And("I submit")
    public void iSubmit() {
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
    }
}
