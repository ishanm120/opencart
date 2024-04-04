package swagLabPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement removeButton;
    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShopping;
    @FindBy(xpath = "//a[@id='item_4_title_link']")
    private WebElement productTitle;
    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private WebElement productDetail;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement productPrice;


    public void clickOnRemoveButtonOnCartPage(){
        removeButton.click();
    }
    public Boolean verifyRemoveButtonShouldNotBeThereOnCartPage(){
        try{
            return removeButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnContinueShoppingButtonOnCartPage(){
        continueShopping.click();
    }

    public Boolean getProductTitle(){
        productTitle.isDisplayed();
        return true;
    }
    public Boolean getProductDetail(){
        productDetail.isDisplayed();
        return true;
    }
    public Boolean getProductPrice(){
        productPrice.isDisplayed();
        return true;
    }

}
