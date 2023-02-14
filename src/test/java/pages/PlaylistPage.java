package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{
    @FindBy(css = "button[title='Delete this playlist']")
    WebElement deleteButtonLocator;


    public PlaylistPage(WebDriver setDriver) {
        super(setDriver);
    }

    public WebElement getDeleteButton(){
        return deleteButtonLocator;

    }

}
