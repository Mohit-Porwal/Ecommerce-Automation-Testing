package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//New class responsible for initializing the webdriver
public class WebDriverInstance {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //To check if the thread is in use
    public static WebDriver getDriver(){
        if(driver.get()==null){
            try{
                driver.set(createDriver());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return driver.get();
    }
    public static WebDriver createDriver() throws IOException {
        WebDriver driver = null;

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerce\\resources\\config.properties"); 
        prop.load(data);
    
        if(prop.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\base\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } 
        driver.manage().window().maximize();
        return driver;
    }
    public static void cleanupDriver(){
        driver.get().quit();
        driver.remove();
    }
}
