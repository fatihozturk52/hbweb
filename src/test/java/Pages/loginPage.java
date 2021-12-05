package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.AssertJUnit.assertEquals;

public class loginPage extends basePage {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "myAccount")
    WebElement homePageLoginDropdown;

    @FindBy(id = "login")
    WebElement homePageLoginButton;

    @FindBy(id = "txtUserName")
    WebElement loginPageEmailButton;

    @FindBy(id = "btnLogin")
    WebElement loginPageEmailLoginButton;

    @FindBy(id = "txtPassword")
    WebElement loginPagePasswordButton;

    @FindBy(id = "btnEmailSelect")
    WebElement loginPagePasswordLoginButton;

    @FindBy(css="#myAccount > span > a")
    WebElement accountText;

    @FindBy(css="#myAccount > span > a > span:nth-child(2)")
    WebElement accountName;

    public void openLoginPage(){
        hover(homePageLoginDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(homePageLoginButton)).click();
    }

    public void successLogin(String eposta, String password){
        wait.until(ExpectedConditions.visibilityOf(loginPageEmailButton)).isDisplayed();
        loginPageEmailButton.sendKeys(eposta);
        click(loginPageEmailLoginButton);
        wait.until(ExpectedConditions.visibilityOf(loginPagePasswordButton)).isDisplayed();
        loginPagePasswordButton.sendKeys(password);
        click(loginPagePasswordLoginButton);
        wait.until(ExpectedConditions.visibilityOf(accountText)).isDisplayed();
        assertEquals("hepsi burada", accountName.getText());
    }
}
