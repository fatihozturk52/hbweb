package Tests;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class hepsiburadaTest extends baseTest {

    @Test
    public void hepsiburadaTest() throws InterruptedException {
        page.loginPage().openLoginPage();
        page.loginPage().successLogin("hbtest@yopmail.com", "sA123456");
        page.hepsiburadaPage().search("iphone 11");
        page.hepsiburadaPage().clickFirstProduct();
        page.hepsiburadaPage().addedBasket();
        String firstProductName = page.hepsiburadaPage().getBasketProductName();
        page.hepsiburadaPage().addedBasketBeforePopupClose();
        page.hepsiburadaPage().secondProductAddedBasket();
        page.hepsiburadaPage().clickLiveSupportPopupCloseButton();
        page.hepsiburadaPage().repairPopupClose();
        String secondProductName = page.hepsiburadaPage().getBasketProductName();
        page.hepsiburadaPage().clickLiveSupportPopupCloseButton();
        page.hepsiburadaPage().addedBasketBeforePopupClose();
        page.hepsiburadaPage().clickBasket();
        assertEquals(firstProductName, page.hepsiburadaPage().getBasketFirstProductName());
        assertEquals(secondProductName, page.hepsiburadaPage().getBasketSecondProductName());
        page.hepsiburadaPage().deleteAllProduct();
    }

    @Test
    public void hepsiburadaTestNonLogin() throws InterruptedException {
        page.hepsiburadaPage().search("iphone 11");
        page.hepsiburadaPage().clickFirstProduct();
        page.hepsiburadaPage().addedBasket();
        String firstProductName = page.hepsiburadaPage().getBasketProductName();
        page.hepsiburadaPage().addedBasketBeforePopupClose();
        page.hepsiburadaPage().secondProductAddedBasket();
        page.hepsiburadaPage().clickLiveSupportPopupCloseButton();
        page.hepsiburadaPage().repairPopupClose();
        String secondProductName = page.hepsiburadaPage().getBasketProductName();
        page.hepsiburadaPage().clickLiveSupportPopupCloseButton();
        page.hepsiburadaPage().addedBasketBeforePopupClose();
        page.hepsiburadaPage().clickBasket();
        assertEquals(firstProductName, page.hepsiburadaPage().getBasketFirstProductName());
        assertEquals(secondProductName, page.hepsiburadaPage().getBasketSecondProductName());
        page.hepsiburadaPage().deleteAllProduct();
    }
}
