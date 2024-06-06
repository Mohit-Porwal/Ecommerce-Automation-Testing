package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ShopContentPanel extends BasePage{

	public WebDriver driver;
	
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.linkText("PROCEED TO CHECKOUT");
	
	public ShopContentPanel() throws IOException {
		super();
		this.driver = getDriver();
	}
	
	public WebElement getContinueShopBtn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn));
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCheckoutBtn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
		return driver.findElement(checkoutBtn);
	}
	
}
