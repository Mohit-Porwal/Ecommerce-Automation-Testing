package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopContentPanel {

	public WebDriver driver;
	
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.linkText("PROCEED TO CHECKOUT");
	
	public ShopContentPanel(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getContinueShopBtn() {
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCheckoutBtn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
		return driver.findElement(checkoutBtn);
	}
	
}
