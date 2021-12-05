package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class hepsiburadaPage extends basePage {
    public hepsiburadaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-inputContainer > div.desktopOldAutosuggestTheme-container > input")
    WebElement searchInput;

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    WebElement search;

    @FindBy(id = "i0")
    WebElement productFirst;

    @FindBy(css = "div.breadcrumbs-wrapper.container.sibling-visible > ul > li:nth-child(1) > a > span")
    WebElement productDetailPage;

    @FindBy(id = "addToCart")
    WebElement addedBasket;

    @FindBy(css = "div > h6")
    WebElement addedBasketPopupGetProductName;

//    @FindBy(css = "h1 > a > svg")
//    WebElement addedBasketBeforePopupClose;

    String addedBasketBeforePopupClose = "h1 > a > svg";

//    @FindBy(css = "#pcwrapper > div > i")
//    WebElement repairPackPopupClose;

    String repairPackPopupClose = "#pcwrapper > div > i";

    String liveSupportButton = "button:nth-child(3) > svg";

    @FindBy(css = "div.seller-container > span > span:nth-child(2) > a")
    WebElement suplierName;

    @FindBy(id = "shoppingCart")
    WebElement basketButton;

    @FindBy(css = "li:nth-of-type(1) .product_name_3Lh3t > a")
    WebElement basketFirstProdcutName;

    @FindBy(css = "li:nth-of-type(2) .product_name_3Lh3t > a")
    WebElement basketSecondProdcutName;

    @FindBy(css = ".delete_all_2uTds")
    WebElement deleteAllProduct;

    @FindBy(css = ".red_3m-Kl")
    WebElement deletePopupDeleteButton;

    @FindBy(css="div.content_Z9h8v > h1")
    WebElement emptyBasketText;

    public void search(String searchKey) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(searchKey);
        click(search);
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productFirst)).click();
        switchWindow();
        wait.until(ExpectedConditions.visibilityOf(productDetailPage)).isDisplayed();
    }

    public void addedBasket() {
        click(addedBasket);
    }

    public String getBasketProductName() {
        wait.until(ExpectedConditions.visibilityOf(addedBasketPopupGetProductName)).isDisplayed();
        return addedBasketPopupGetProductName.getText();
    }

    public void addedBasketBeforePopupClose() {
        if (exists(By.cssSelector(addedBasketBeforePopupClose))) {
            click(By.cssSelector(addedBasketBeforePopupClose));
        }
    }

    public void secondProductAddedBasket() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            if (driver.findElement(By.cssSelector("tr:nth-child(" + i + ") > td.shipping-and-campaigns > div.merchant-info > a.merchantStore.small")).getText() != suplierName.getText()) {
                scroolDown();
                driver.findElement(By.cssSelector("div.marketplace-list > table > tbody > tr:nth-child(" + i + ") > td.form-area > div > form > button")).click();
                break;
            }
        }
        Thread.sleep(1000);
    }

    public void repairPopupClose() {
        if (exists(By.cssSelector(repairPackPopupClose))) {
            click(By.cssSelector(repairPackPopupClose));
        }
    }

    public void clickLiveSupportPopupCloseButton() {
        if (exists(By.cssSelector(liveSupportButton))) {
            click(By.cssSelector(liveSupportButton));
        }
    }

    public void clickBasket() {
        click(basketButton);
    }

    public String getBasketFirstProductName() {
        wait.until(ExpectedConditions.visibilityOf(basketFirstProdcutName)).isDisplayed();
        return basketFirstProdcutName.getText();
    }

    public String getBasketSecondProductName() {
        wait.until(ExpectedConditions.visibilityOf(basketSecondProdcutName)).isDisplayed();
        return basketSecondProdcutName.getText();
    }

    public void deleteAllProduct(){
        click(deleteAllProduct);
        wait.until(ExpectedConditions.visibilityOf(deletePopupDeleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(emptyBasketText)).isDisplayed();
    }
}
