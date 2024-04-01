package stepdefinitions;

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

    public LoginStep(TestContext testContext) {
        this.driver = testContext.getDriver();
        loginPage = new LoginPage(driver);
    }
    @Given("User is on login page")
    public void verifyLoginPage() {
        Assert.assertEquals("https://www.saucedemo.com/",loginPage.getUrl(),"Url not match");
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPssword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User click on login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("User should be logged in successfully")
    public void verifyLoginSuccessful(){
        Assert.assertTrue(loginPage.verifyHamburgerMenu());
    }

    @When("User enters valid username and valid password")
    public void enterValidUsernameAndPassword(String username,String password){
        loginPage.enterValidUsername(username);
        loginPage.enterValidPassword(password);
    }
}