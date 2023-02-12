import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.UUID;

public class LoginTests extends LoginPage {

    public LoginTests(WebDriver givenDriver) {
        super(givenDriver);
    }

//    @DataProvider(name="IncorrectLoginProviders")
//    public static Object[][] getDataFromDataProviders(){
//        return new Object[][]{
//                {"notExisting@email.com", "NotExistingPassword"},
//                {"demo@class.com", ""},
//                {"", ""},
//        };
//    }
    @Test
    public void negativeLoginTests() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("demo@class.com");
        loginPage.passwordField("password");
        loginPage.clickButtonSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("demo@class.com");
        loginPage.passwordField("te$t$tudent");
        loginPage.clickButtonSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("demo@class.com");
        loginPage.passwordField("student");
        loginPage.clickButtonSubmit();
        Assert.assertTrue(loginPage.getsubmitButton().isDisplayed());
    }

    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("demo@class.com");
        loginPage.clickButtonSubmit();

        Assert.assertTrue(loginPage.getsubmitButton().isDisplayed());
    }

    @Test
    public void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("dem@class.com");
        loginPage.passwordField("te$t$tudent");
        loginPage.clickButtonSubmit();

        Assert.assertTrue(loginPage.getsubmitButton().isDisplayed());
    }

    @Test
    public void changeProfileNameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("demo@class.com");
        loginPage.passwordField("te$t$tudent");
        loginPage.clickButtonSubmit();

        LoginPage.openUserProfile();
        String user = generateRandomName();
        setName(user);
        setPassword();
        saveProfile();
        loginPage.getSuccessBanner();
        Assert.assertEquals(getUsername(), user);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }


}
//        Email("demo@class.com");
//        Password("te$t$tudent");