package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecentlyPlayedPage extends BasePage{
    WebElement recentlyPlayedWrapper = driver.findElement(By.xpath("//*[id='recentlyPlayedWrapper']"));
    public RecentlyPlayedPage(WebDriver givenDriver)
    { super(givenDriver);}
    public WebElement getRecentlyPlayedWrapper() {
        return recentlyPlayedWrapper;
    }
}
