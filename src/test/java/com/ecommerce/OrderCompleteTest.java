package com.ecommerce;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import base.Hooks;
import pageObjects.DeliveryAddress;
import pageObjects.Homepage;
import pageObjects.Payment;
import pageObjects.PersonalInfo;
import pageObjects.ShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductpage;
import pageObjects.ShoppingCart;

public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}
	
	@Test
	public void endToEndTest() throws InterruptedException, IOException {
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
		
		Thread.sleep(5000);
		
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		Thread.sleep(5000);
		cart.getProceedCheckoutBtn().click();
		
        PersonalInfo info = new PersonalInfo();
        info.getGenderMr().click();
        info.getFirstNameField().sendKeys("John");
		info.getLastnameField().sendKeys("Smith");
		info.getEmailField().sendKeys("jsmith@hotmail.com");
		info.getTermsConditionsCheckbox().click();
		info.getContinueBtn().click();

        DeliveryAddress address = new DeliveryAddress();
        address.getAddressField().sendKeys("123 Main Street");
        address.getCityField().sendKeys("Rochester");
        Select state = new Select(address.getStateDropdown());
		state.selectByVisibleText("Michigan");
		address.getPostcodeField().sendKeys("77021");
		address.getContinueBtn().click();

        ShippingMethod shipMethod = new ShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

        Payment payment = new Payment();
		payment.getPayByCheckRadioBtn().click();
		payment.getTermsConditionsCheckbox().click();
		payment.getOrderBtn().click();
	}

}
