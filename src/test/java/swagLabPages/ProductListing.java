package swagLabPages;

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

    @FindBy(xpath = "//*[contains(text(),'Products')]")
    private WebElement productTxt;

    @FindBy(xpath ="//div[@class='inventory_item']")
    private List<WebElement> listOfElements;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement cartBtn;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIcn;
    @FindBy(xpath = "//span[@class='title' and contains(text(),'Your Cart')]")
    private WebElement cartPageTitle;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;
    @FindBy(xpath = "//span[@class='title' and contains(text(),'Checkout: Your Information')]")
    private WebElement checkoutInfoPageTitle;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipcode;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//span[@class='title' and contains(text(),'Checkout: Overview')]")
    private WebElement checkoutPageTxt;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;
    @FindBy(xpath = "//h2[@class='complete-header' and contains(text(),'Thank you for your order!')]")
    private WebElement orderSuccessfulTxt;


    public Boolean valifyProductTxt(){
        return productTxt.isDisplayed();
    }

    public List<WebElement> getListOfElements() {
        return listOfElements;

    }

    public void clickOnCartBtn(){
        cartBtn.click();
    }
    public void clickOnCartIcon(){
        cartIcn.click();
    }
    public Boolean validateCartPage(){
       return cartPageTitle.isDisplayed();
    }

    public void clickOnCheckoutBtn(){
        checkoutBtn.click();
    }
    public Boolean validateCheckoutInfoPage(){
        return checkoutInfoPageTitle.isDisplayed();
    }

    public void enterFirstName(){
        firstName.sendKeys();
    }
    public void enterLastName(){
        lastName.sendKeys();
    }
    public void enterZipcode(){
        zipcode.sendKeys();
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }
    public Boolean validateCheckoutPage(){
        return checkoutPageTxt.isDisplayed();
    }
    public void clickOnFinishBtn(){
        finishBtn.click();
    }
    public Boolean validateOrderIsSuccessful(){
        return orderSuccessfulTxt.isDisplayed();
    }


}
