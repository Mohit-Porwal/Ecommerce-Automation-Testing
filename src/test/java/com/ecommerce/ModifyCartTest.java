package com.ecommerce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import org.testng.Assert;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductpage;
import pageObjects.ShoppingCart;

public class ModifyCartTest extends BasePage{

    public ModifyCartTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver = null;
    }

    @Test
    public void addRemoveItem() throws IOException{
        
        Homepage home = new Homepage(driver);

		//handles cookie prompt
		home.getCookie().click();

		home.getTestStoreLink().click();
		
		ShopHomepage shopHome = new ShopHomepage(driver);
		shopHome.getProdOne().click();
		
		ShopProductpage shopProd = new ShopProductpage(driver);
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

        ShopContentPanel panel = new ShopContentPanel(driver);
        panel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();

        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();

        panel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getDeleteItemTwo().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        Assert.assertEquals(cart.getTotalAmount().getText(),"$45.24");
    }
}
