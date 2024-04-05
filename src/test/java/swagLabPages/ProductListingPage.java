package swagLabPages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListingPage {
    private WebDriver driver;
    private Select select;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement cartBtn;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIcn;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCode;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeButton;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterDropdown;
    @FindBy(xpath = "//*[@class ='inventory_item_name ']")
    private List<WebElement> productsNameFromAToZ;


    public void productListingPage(){
        driver.getTitle();
    }

    public void clickOnAddToCartBtn(){
        cartBtn.click();
    }
    public void clickOnCartIcon(){
        cartIcn.click();
    }
    public boolean cartPage(){
       return checkoutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn(){
        checkoutBtn.click();
    }
    public Boolean checkoutInfoPage(){
        return continueBtn.isDisplayed();
    }

    public ProductListingPage enterFirstName(String firstname){
        firstName.sendKeys(firstname);
        return this;
    }
    public ProductListingPage enterLastName(String lastname){
        lastName.sendKeys(lastname);
        return this;
    }
    public ProductListingPage enterZipcode(String zipcode){
        zipCode.sendKeys(zipcode);
        return this;
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }
    public Boolean checkoutPage(){
        return finishButton.isDisplayed();
    }
    public void clickOnFinishButton(){
        finishButton.click();
    }
    public Boolean orderPlacedTitle(){
        return backHomeButton.isDisplayed();
    }
    public void clickOnFilterBtn(){
        filterDropdown.click();
    }
    public void selectNameFilterAsAToZ() {
        select = new Select(filterDropdown);
        select.selectByVisibleText(Constants.NAME_A_TO_Z);
    }

    public List<WebElement> getListOfElements() {
        return productsNameFromAToZ;
    }
}