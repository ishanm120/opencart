package swagLabPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickOnLoginBtn() {
        loginButton.click();
    }
    public Boolean verifyHamburgerMenu(){
        return hamburgerMenu.isDisplayed();
    }

    public void enterValidUsername(){
        usernameInput.sendKeys("standard_user");
    }
    public void enterValidPassword(){
        passwordInput.sendKeys("secret_sauce");
    }

}
