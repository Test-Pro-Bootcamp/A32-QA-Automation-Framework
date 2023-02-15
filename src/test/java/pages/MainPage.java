package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    By searchFieldLocator = By.cssSelector("input[placeholder='Press F to search']");

    public MainPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean findSearchField(){
       driver.findElement(searchFieldLocator).isDisplayed();
       return true;
    }

}
