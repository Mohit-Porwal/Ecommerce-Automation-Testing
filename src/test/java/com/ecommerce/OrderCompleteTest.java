package com.ecommerce;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BasePage;
import pageObjects.DeliveryAddress;
import pageObjects.Homepage;
import pageObjects.Payment;
import pageObjects.PersonalInfo;
import pageObjects.ShippingMethod;
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
		info.getEmailField().sendKeys("jsmith@hotmail.com");
		info.getTermsConditionsCheckbox().click();
		info.getContinueBtn().click();

        DeliveryAddress address = new DeliveryAddress(driver);
        address.getAddressField().sendKeys("123 Main Street");
        address.getCityField().sendKeys("Rochester");
        Select state = new Select(address.getStateDropdown());
		state.selectByVisibleText("Michigan");
		address.getPostcodeField().sendKeys("77021");
		address.getContinueBtn().click();

        ShippingMethod shipMethod = new ShippingMethod(driver);
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

        Payment payment = new Payment(driver);
		payment.getPayByCheckRadioBtn().click();
		payment.getTermsConditionsCheckbox().click();
		payment.getOrderBtn().click();
	}

}
