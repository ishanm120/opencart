package commonPage;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonMethodPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonMethodPage(WebDriver driver){
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    //method for wait until element to be visible
    public WebElement elementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //method for wait until element to be clickable
    public void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Method of explicit wait for a specific element with a custom time
    protected WebElement waitForElement(WebElement element, Duration timeout) {
        wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
