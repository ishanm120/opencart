package swagLabPages;

import cucumberTestContext.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwagLabsBase {
    protected WebDriver driver;
    protected TestContext testContext;

    public void setUp() {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        testContext = new TestContext();
        testContext.setDriver(driver);
    }

    public void tearDown() {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

