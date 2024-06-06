package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class Payment extends BasePage{

	public WebDriver driver;
	
	By payByCheck = By.xpath("//span[.='Pay by Check']");
	By payByWire = By.xpath("//span[.='Pay by bank wire']");
	By termsAndConditions = By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
	By orderBtn = By.xpath("//div[@id='payment-confirmation']//button[@type='submit']");
	
	public Payment() throws IOException {
		super();
		this.driver = getDriver();
	}
	
	public WebElement getPayByCheckRadioBtn() {
		return driver.findElement(payByCheck);
	}
	
	public WebElement getPayByWireRadioBtn() {
		return driver.findElement(payByWire);
	}
	
	public WebElement getTermsConditionsCheckbox() {
		return driver.findElement(termsAndConditions);
	}

	public WebElement getOrderBtn() {
		return driver.findElement(orderBtn);
	}
	
}
