package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import cucumberTestContext.TestContext;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import swagLabPages.LoginPage;
import swagLabPages.ProductListing;

public class ProductListingStep {
    private WebDriver driver;
    private final ProductListing productListing;
    private final LoginPage loginPage;
    private ExtentReports extent;

    public ProductListingStep(TestContext testContext) {
        this.driver = testContext.getDriver();
        productListing = new ProductListing(driver);
        loginPage = new LoginPage(driver);
        extent = testContext.getExtent();
    }

    @When("User navigate to product listing page")
    public void navigateOnListingPage(){
       productListing.productListingPage();
       extent.createTest("Navigate on product listing page.").log(Status.PASS, "navigate on product listing page successfully.");
    }

    @When("User click on add to cart button")
    public void clickOnAddToCartBtn() {
        productListing.clickOnAddToCartBtn();
        extent.createTest("Adding product into cart.").log(Status.PASS, "Adding product into cart successfully.");
    }
    @And("User click on cart icon")
    public void clickOnCartIcon() {
        productListing.clickOnCartIcon();
        extent.createTest("Click on cart icon.").log(Status.PASS, "Click on cart icon successfully.");
    }
    @Then("User should be on cart page")
    public void verifyCartPage() {
        Assert.assertTrue(productListing.cartPage(),"cart page not visible");
        extent.createTest("Verify cart page.").log(Status.PASS, "Verify cart page successfully.");
    }
    @And("User click on checkout button")
    public void clickOnCheckoutBtn() {
        productListing.clickOnCheckoutBtn();
        extent.createTest("Click on checkout button.").log(Status.PASS, "Click on checkout button successfully.");
    }
    @Then("User should be on checkout information page")
    public void verifyCheckoutInformationPage() {
        Assert.assertTrue(productListing.checkoutInfoPage(),"checkout info page not visible");
        extent.createTest("Verify checkout info page.").log(Status.PASS, "Verify checkout info page successfully.");
    }
    @And("User enters firstName as {string} lastName as {string} and zipcode as {string}")
    public void entersNameAndZipcode(String firstname, String lastname, String zipcode) {
        productListing.enterFirstName(firstname)
                      .enterLastName(lastname)
                      .enterZipcode(zipcode);
        extent.createTest("Enter firstname, lastname and zipcode.").log(Status.PASS, "Enter firstname, lastname and zipcode successfully.");

    }
    @And("User click on continue button")
    public void clickOnContinueBtn() {
        productListing.clickOnContinueBtn();
        extent.createTest("Click on continue button.").log(Status.PASS, "Click on continue button successfully.");
    }
    @Then("User should be on checkout overview page")
    public void verifyCheckoutPage() {
        Assert.assertTrue(productListing.checkoutPage(),"checkout page not visible");
        extent.createTest("Verify checkout page.").log(Status.PASS, "Verify checkout page successfully.");
    }
    @And("User click on finish button")
    public void clickOnFinishBtn() {
        productListing.clickOnFinishButton();
        extent.createTest("Click on finish button.").log(Status.PASS, "Click on finish button successfully.");
    }
    @Then("User should able to place order successfully")
    public void verifyOrderPlacedSuccessfully() {
        Assert.assertTrue(productListing.orderPlacedTitle(),"order successful page is not visible");
        extent.createTest("Verify order is placed.").log(Status.PASS, "Verify order is placed successfully.");
    }
    @When("User add {int} products in cart")
    public void addMultipleProductInCart(int productCount){
        productListing.addMultipleProductsIntoCart(productCount);
    }
    @Then("Verify {int} of product in cart")
    public void verifyProductCount(int expectedProductCount){
        Assert.assertEquals(productListing.getCountOfProductInCart(),expectedProductCount,"Product Count in cart is different");
    }
    @Then("Verify User should navigate to listing page")
    public void verifyUserIsOnListingPage(){
        Assert.assertEquals("Products",productListing.verifyUserIsOnListingPage(),"Text mismatch");
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",productListing.getUrlOfListingPage(),"Url mismatch"+ productListing.getUrlOfListingPage());
    }
}
