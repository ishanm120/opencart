package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.Constants;
import cucumberTestContext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private TestContext testContext;
    private ExtentReports extent;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
        // Initialize ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        testContext.setExtent(extent); // Pass ExtentReports instance to TestContext
    }
    // method to read properties file
    private Properties loadProperties() {
        Properties properties = new Properties();
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
        ChromeOptions co = new ChromeOptions();
        co.setBrowserVersion("120");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        String baseURL = loadProperties().getProperty("baseUrl");
        driver.get(baseURL);
        //impicit wait
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        //we set driver in testContext
        testContext.setDriver(driver);

    }

    @After
    public void tearDown() {
        testContext.getDriver().quit();
        // ExtentReports teardown
        extent.flush();

    }
}



