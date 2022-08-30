package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseActions {
    public static WebDriver driver;

    public WebDriver WebDriverManager() throws IOException
    {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("Demo_Buyer");
        String browser_properties = prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        // result = testCondition ? value1 : value2

        String browser = browser_maven!=null ? browser_maven : browser_properties;



        if(driver == null)
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            if(browser.equalsIgnoreCase("firefox"))
            {
               WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get(url);
        }

        return driver;

    }


}
