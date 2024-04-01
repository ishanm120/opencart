package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumberTestContext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    private TestContext testContext;

    protected ExtentReports extent;
    private Properties properties;


    public Hooks(TestContext testContext) {
        this.testContext = testContext;

    }
    // method to read properties file
    private Properties loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Before
    public void setUp() {
        WebDriver driver;
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ChromeOptions co = new ChromeOptions();
        co.setBrowserVersion("120");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        String baseURL = loadProperties().getProperty("baseUrl");
        driver.get(baseURL);
        //impicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //we set driver in testContext
        testContext.setDriver(driver);
    }

    @After
    public void tearDown() {
        testContext.getDriver().quit();
    }
}



