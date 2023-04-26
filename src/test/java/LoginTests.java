import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginTests extends BaseTest {
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login("burkovads@mail.ru", "Julka@0721")
                .clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "student")
                .clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("demo@class.com");
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(loginPage.submitLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.registrationLink().isDisplayed(), "==== Registration link displayed ====");
    }

    @Test
    public void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("dem@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(loginPage.submitLoginButton().isDisplayed());
        String link = loginPage.registrationLink().getText();
        System.out.println("==== This is our link text ==== " + link);
    }

    @Test
    public void changeProfileNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("burkovads@mail.ru")
                .providePassword("Julka@0721")
                .clickSubmitBtn()
                .openUserProfile();
        String user = loginPage.generateRandomName();
        loginPage.setName(user)
                .setPassword("Julka@0721")
                .saveProfile();
        homePage.successBanner();
        Assert.assertEquals(loginPage.getUsername(), user);
    }
}
//        Email("demo@class.com");
//        Password("te$t$tudent");