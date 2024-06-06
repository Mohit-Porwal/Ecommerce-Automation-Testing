package com.ecommerce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.Hooks;

import org.testng.Assert;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductpage;
import pageObjects.ShoppingCart;

public class ModifyCartTest extends Hooks{

    public ModifyCartTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException{
        
        Homepage home = new Homepage();

		//handles cookie prompt
		home.getCookie().click();

		home.getTestStoreLink().click();
		
		ShopHomepage shopHome = new ShopHomepage();
		shopHome.getProdOne().click();
		
		ShopProductpage shopProd = new ShopProductpage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

        ShopContentPanel panel = new ShopContentPanel();
        panel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();

        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();

        panel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        //using wait to ensure the deletion of item two has taken place
        waitForElementInvisible(cart.getDeleteItemTwo(), Duration.ofSeconds(10));

        Assert.assertEquals(cart.getTotalAmount().getText(),"$45.24");
    }
}
