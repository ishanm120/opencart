package swagLabPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListing {
    private WebDriver driver;

    public ProductListing(WebDriver driver) {
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
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartCount;
    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartButtons;
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement listingPageHeadLine;


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

    public ProductListing enterFirstName(String firstname){
        firstName.sendKeys(firstname);
        return this;
    }
    public ProductListing enterLastName(String lastname){
        lastName.sendKeys(lastname);
        return this;
    }
    public ProductListing enterZipcode(String zipcode){
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
    public void addMultipleProductsIntoCart(int productCount){
        for(int i=0; i<=productCount-1;i++){
            if (!addToCartButtons.get(i).isDisplayed()){
                JavascriptExecutor js= (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,250)","");
            }
                  addToCartButtons.get(i).click();

        }
    }
    public int getCountOfProductInCart(){
        return Integer.parseInt(cartCount.getText());
    }
    public String verifyUserIsOnListingPage(){
        return listingPageHeadLine.getText();
    }
    public String getUrlOfListingPage(){
        return driver.getCurrentUrl();
    }

}
