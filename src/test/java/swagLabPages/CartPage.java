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
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement listItems;
    public void clickOnRemoveButton(){
        removeButton.click();
    }

    public Boolean verifyRemoveButtonShouldNotBeThere(){
        try{
            return removeButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnContinueShoppingButton(){
        continueShopping.click();
    }
    public String verifyUserIsOnListingPage(){
        return listItems.getText();
    }

}
