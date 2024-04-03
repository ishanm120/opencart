package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import cucumberTestContext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import swagLabPages.CartPage;
import swagLabPages.LoginPage;

public class CartPageSteps {
    private WebDriver driver;
    private final CartPage cartPage;
    private ExtentReports extent;


    public CartPageSteps(TestContext testContext) {
        this.driver = testContext.getDriver();
        cartPage = new CartPage(driver);
        extent = testContext.getExtent();
    }
    @And("User click on remove button")
    public void clickOnRemoveButton(){
        cartPage.clickOnRemoveButton();
    }
    @Then("Verify product should be removed from the cart")
    public void verifyRemoveButtonShouldNotBeThere(){
        Assert.assertFalse(cartPage.verifyRemoveButtonShouldNotBeThere(),"Element found");
    }
    @And("User click on continue shopping button")
    public void clickOnContinueShoppingButton(){
        cartPage.clickOnContinueShoppingButton();
    }
    @Then("Verify User should navigate to listing page")
    public void verifyUserIsOnListingPage(){
        Assert.assertEquals("Products",cartPage.verifyUserIsOnListingPage(),"Text mismatch");
    }

}
