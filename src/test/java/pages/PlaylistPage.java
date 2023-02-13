package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{
    private final By deleteButtonLocator = By.cssSelector("button[title='Delete this playlist']");
    public WebElement getDeleteButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator));

    }

}
