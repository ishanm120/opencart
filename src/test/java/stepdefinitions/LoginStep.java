package stepdefinitions;

import cucumberTestContext.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swagLabPages.LoginPage;
import swagLabPages.SwagLabsBase;


public class LoginStep extends SwagLabsBase {
    private LoginPage loginPage;
    private TestContext testContext;

    @Before
    public void star() {
        setUp();
        testContext = new TestContext();
        testContext.setDriver(driver);
    }

    @After
    public void end() {
        tearDown();
    }

    @Given("User is on login page")
    public void verifyLoginPage() {
        String Url = testContext.getDriver().getCurrentUrl();
        Assert.assertTrue(true, Url);
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPssword(String username, String password) {
        loginPage = new LoginPage(testContext.getDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User click on login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("User should be logged in successfully")
    public void verifyLoginSuccessful() {
        Assert.assertTrue(loginPage.verifyHamburgerMenu());
    }

    @When("User enters valid username and valid password")
    public void enterValidUsernameAndPassword(){

        loginPage.enterValidUsername();
        loginPage.enterValidPassword();
    }


}