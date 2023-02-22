package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecentlyPlayedPage extends BasePage {
    @FindBy(xpath = "//*[id='recentlyPlayedWrapper']")
    private WebElement recentlyPlayedWrapper;

    public RecentlyPlayedPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getRecentlyPlayedWrapper() {
        return recentlyPlayedWrapper;
    }
}
