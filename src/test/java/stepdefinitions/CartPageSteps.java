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
    @And("User click on remove button on cart page")
    public void clickOnRemoveButtonOnCartPage(){
        cartPage.clickOnRemoveButtonOnCartPage();
    }
    @Then("Verify product should be removed from the cart")
    public void verifyRemoveButtonShouldNotBeThereOnCartPage(){
        Assert.assertFalse(cartPage.verifyRemoveButtonShouldNotBeThereOnCartPage(),"Element found");
    }
    @And("User click on continue shopping button on cart page")
    public void clickOnContinueShoppingButtonOnCartPage(){
        cartPage.clickOnContinueShoppingButtonOnCartPage();
    }

    @Then("Verify product title detail and price is available on cart page")
    public void verifyProductTitleDetailPriceAvailableOnCartPage(){
        Assert.assertTrue(cartPage.getProductTitle(),"title is missing on cart page");
        Assert.assertTrue(cartPage.getProductDetail(),"Product Detail is missing on cart page");
        Assert.assertTrue(cartPage.getProductPrice(),"Product price is missing from cart page");
    }

}
