package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException{
        prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerce\\resources\\config.properties"); 
        prop.load(data);
    }
    
    public WebDriver getDriver(){
       if(prop.getProperty("browser").equals("chrome")){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\base\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
       } 
       driver.manage().window().maximize();
       return driver;
    }

    public String getUrl(){
        url = prop.getProperty("url");
        return url;
    }
    
}
