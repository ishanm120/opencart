package stepdefinitions;

import cucumberTestContext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import swagLabPages.ProductListing;

public class ProductListingStep {
    private WebDriver driver;
    private final ProductListing productListing;

    public ProductListingStep(TestContext testContext) {
        this.driver = testContext.getDriver();
        productListing = new ProductListing(driver);
    }

    @When("User navigate to product listing page")
    public void verifyListingPage(){
        Assert.assertTrue(productListing.valifyProductTxt(),"Product text not visible");
    }
    @Then("User should able to see list of product")
    public void verifyListOfProduct(){
        Assert.assertEquals(productListing.verifyListPage(),"Product","Product title mismatch");
    }

    @When("User click on add to cart button")
    public void clickOnAddToCartBtn() {
        productListing.clickOnCartBtn();
    }
    @And("User click on cart icon")
    public void clickOnCartIcon() {
        productListing.clickOnCartIcon();
    }
    @Then("User should be on cart page")
    public void navigateOnCartPage() {
        Assert.assertEquals(productListing.validateCartPage(),"Your Cart","cart title mismatch");

    }
    @And("User click on checkout button")
    public void clickOnCheckoutBtn() {
        productListing.clickOnCheckoutBtn();
    }
    @Then("User should be on checkout information page")
    public void navigateOnCheckoutInformationPage() {
        Assert.assertEquals(productListing.validateCheckoutInfoPage(),"Checkout: Your Information","checkout text mismatch");

    }
    @And("User enters first name as {string} last name as {string} and zipcode as {string}")
    public void entersNameAndZipcode() {
        productListing.enterFirstName();
        productListing.enterLastName();
        productListing.enterZipcode();
    }
    @And("User click on continue button")
    public void clickOnContinueBtn() {
        productListing.clickOnContinueBtn();
    }
    @Then("User should be on checkout overview page")
    public void navigateOnCheckoutOverviewPage() {
        Assert.assertEquals(productListing.validateCheckoutPage(),"Checkout: Overview","checkout overview text mismatch");

    }
    @And("User click on finish button")
    public void clickOnFinishBtn() {
        productListing.clickOnFinishBtn();
    }
    @Then("User should able to place order successfully")
    public void orderPlacedSuccessfully() {
        Assert.assertEquals(productListing.validateOrderIsSuccessful(),"Checkout: Complete!","order complete message mismatch");

    }
}
