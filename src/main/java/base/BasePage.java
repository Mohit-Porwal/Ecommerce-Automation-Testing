package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private String url;
    private Properties prop;

    public BasePage() throws IOException{
        prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerce\\resources\\config.properties"); 
        prop.load(data);
    }
    
    public static WebDriver getDriver() throws IOException{
        return WebDriverInstance.getDriver();
    }

    public String getUrl(){
        url = prop.getProperty("url");
        return url;
    }
    
    public static void waitForElementInvisible(WebElement element, Duration timer) throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), timer);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
