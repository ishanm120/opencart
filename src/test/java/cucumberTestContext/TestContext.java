package cucumberTestContext;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;
    private ExtentReports extent;

    public TestContext() {
        driver = null;
        extent=null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public void setExtent(ExtentReports extent) {
        this.extent = extent;
    }
}
