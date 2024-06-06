package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShippingMethod extends BasePage{
	public WebDriver driver;
	
	By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
	By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

	public ShippingMethod() throws IOException {
		super();
		this.driver = getDriver();
	}
	
	public WebElement getDeliveryMsgTextbox() {
		return driver.findElement(deliveryMsgTextbox);
	}
	
	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}
}