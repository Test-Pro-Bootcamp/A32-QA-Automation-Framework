package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends LoginPage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By avatarIcon =By.className("img.avatar");

    public WebElement getUserAvatar (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }


}