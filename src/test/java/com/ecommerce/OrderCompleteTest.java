package com.ecommerce;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BasePage;
import pageObjects.Homepage;
import pageObjects.PersonalInfo;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductpage;
import pageObjects.ShoppingCart;

public class OrderCompleteTest extends BasePage {

	public OrderCompleteTest() throws IOException {
		super();
	}
	
	@BeforeTest
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
	
	@Test
	public void endToEndTest() throws InterruptedException, IOException {
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
		
		Thread.sleep(5000);
		
		ShopContentPanel cPanel = new ShopContentPanel(driver);
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		Thread.sleep(5000);
		cart.getProceedCheckoutBtn().click();
		
        PersonalInfo info = new PersonalInfo(driver);
        info.getGenderMr().click();
        info.getFirstNameField().sendKeys("John");
		info.getLastnameField().sendKeys("Smith");
		info.getEmailField().sendKeys("johnsmith@test.com");
		info.getTermsConditionsCheckbox().click();
		info.getContinueBtn().click();

        
	}

}
