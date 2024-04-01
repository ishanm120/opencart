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
        productListing.valifyProductTxt();
        Assert.assertTrue(true,"Products");
    }
    @Then("User should able to see list of product")
    public void verifyListOfProduct(){
        productListing.getListOfElements();
    }

    @When("User click on add to cart button")
    public void clickOnAddToCartBtn() {
        productListing.clickOnCartBtn();
    }
    @And("User click on cart icon")
    public void clickOnCartIcon() {
        productListing.clickOnCartIcon();
    }
    @And("User navigate to cart page")
    public void navigateOnCartPage() {
        productListing.validateCartPage();
    }
    @And("User click on checkout button")
    public void clickOnCheckoutBtn() {
        productListing.clickOnCheckoutBtn();
    }
    @And("User navigate to checkout information page")
    public void navigateOnCheckoutInformationPage() {
        productListing.validateCheckoutInfoPage();
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
    @And("User navigate to checkout overview page")
    public void navigateOnCheckoutOverviewPage() {
        productListing.validateCheckoutPage();
    }
    @And("User click on finish button")
    public void clickOnFinishBtn() {
        productListing.clickOnFinishBtn();
    }
    @Then("User should able to place order successfully")
    public void orderPlacedSuccessfully() {
        productListing.validateOrderIsSuccessful();
    }
}
