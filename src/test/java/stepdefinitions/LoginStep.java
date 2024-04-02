package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import cucumberTestContext.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swagLabPages.LoginPage;


public class LoginStep {
    private WebDriver driver;
    private final LoginPage loginPage;
    private ExtentReports extent;


    public LoginStep(TestContext testContext) {
        this.driver = testContext.getDriver();
        loginPage = new LoginPage(driver);
        extent = testContext.getExtent();
    }
    @Given("User should on login page")
    public void verifyLoginPage() {
        Assert.assertTrue(loginPage.verifyLoginButton(),"login page not visible");
        extent.createTest("Verify Login Page.").log(Status.PASS, "Login page verified successfully.");
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username)
                .enterPassword(password);
        extent.createTest("entered username and password.").log(Status.PASS, "entered username and password successfully.");
    }

    @And("User click on login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginBtn();
        extent.createTest("click on login button.").log(Status.PASS, "click on login button successfully.");
    }

    @Then("User should be logged in successfully")
    public void verifyLoginSuccessful() throws InterruptedException {
        loginPage.clickOnHamburgerMenu();
        Thread.sleep(500);
        Assert.assertTrue(loginPage.logoutButton(), "user is not able to login");
        extent.createTest("Verify Login should be Successful.").log(Status.PASS, "Login Successful.");
    }

}