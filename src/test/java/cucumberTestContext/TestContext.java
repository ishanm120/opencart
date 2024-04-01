package cucumberTestContext;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;

    public TestContext() {
        driver = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
