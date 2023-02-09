package com.hillel.core.driver;

import com.hillel.core.Browsers;
import com.hillel.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;



public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browsers");
    private static WebDriver driver;
    public static WebDriver getDriver(){
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;

        return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }
    public static WebDriver getDriver(Browsers browsers){
        switch (browsers){
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case OPERA:
                return getOperaDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw new IllegalArgumentException("Wrong browser was chose");

        }
   }
   public static WebDriver getChromeDriver(){

        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        return driver;
   }
    public static WebDriver getFirefoxDriver(){
        if (driver==null){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public static WebDriver getOperaDriver(){
        if (driver==null){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }
    public static WebDriver getEdgeDriver(){
        if (driver==null){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }
}
