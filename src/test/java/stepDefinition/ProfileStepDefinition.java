package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;

public class ProfileStepDefinition extends BaseDefinition {
    WebDriver driver;
    @Given("I open Login Page")
    public void openLoginPage() {
        getThreadLocal().get("https://bbb.testpro.io");
    }
    @When("I login success")
    public void iLoginSuccessProfile() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.login();
    }
    @And("I open Profile page")
    public void iOpenProfilePage() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.openUserProfile();
    }
    @And("I enter random name")
    public void iEnterRandomName() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        String user = profilePage.generateRandomName();
        profilePage.setName(user)
                .setPassword("Julka@0721")
                .saveProfile();
    }
    @And("I enter password")
    public void iEnterCurrentPassword() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.setPassword("Julka@0721");
    }
    @And("I click Save")
    public void iClickSave() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.saveProfile();
    }

    @Then("I get notification")
    public void iGetNotificationProfile() {
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        String user = profilePage.generateRandomName();
        String notifyProfileUpdated = "Profile updated";
        homePage.showSuccessBanner(notifyProfileUpdated);
        Assert.assertEquals(profilePage.getUsername(), user);
    }
    @And("I choose color theme")
    public void iChooseColorTheme() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.chooseTheme();
    }
    @Then("The color theme is changed")
    public void theColorThemeIsChanged() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        Assert.assertTrue(profilePage.checkSelectedThemeColor());
    }
    @And("I click on the first checkbox Notify")
    public void iClickOnTheFirstCheckbox() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.selectCheckboxNotify();
    }
    @Then("I see the tick inside the box")
    public void iSeeTheTickInsideTheBox() {
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        Assert.assertTrue(profilePage.checkSelectedCheckboxNotify());
    }
}
