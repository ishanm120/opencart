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

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutBtn;


    public Boolean verifyLoginButton(){
        return loginButton.isDisplayed();
    }
    public LoginPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }
    public void clickOnLoginBtn() {
        loginButton.click();
    }
    public void clickOnHamburgerMenu(){
        hamburgerMenu.click();
    }

    public Boolean logoutButton(){
        return logoutBtn.isDisplayed();
    }

}
