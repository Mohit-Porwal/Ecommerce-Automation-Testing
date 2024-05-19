package com.ecommerce;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import base.BasePage;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductpage;
import pageObjects.ShoppingCart;

public class OrderCompleteTest extends BasePage{

    public OrderCompleteTest() throws IOException{
        super();
    }

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get(getUrl());
    }

    @Test
    public void endToEndTest() throws InterruptedException{
        Homepage home = new Homepage(driver);
        home.getTestStoreLink().click();

        ShopHomepage shop = new ShopHomepage(driver);
        shop.getProdOne().click();

        ShopProductpage shopProd = new ShopProductpage(driver);
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        ShopContentPanel cPanel = new ShopContentPanel(driver);
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getHavePromo().click();
        cart.getPromoTextbox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        Thread.sleep(5000);
        cart.getProceedCheckoutBtn().click();
        
    }
}
