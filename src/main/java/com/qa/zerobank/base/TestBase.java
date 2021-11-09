package com.qa.zerobank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Alfonso Holmes\\eclipse-workspace\\POM_Selenium_Framework" +
					"\\src\\main\\java\\com\\qa\\zerobank\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// initializing browser driver
	public static void initialization() {
		String browserName = prop.getProperty("DRIVER.browser");
		String bdPath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\qa\\zerobank\\browserdrivers\\";
		if(browserName.equalsIgnoreCase("chrome")){
		System.out.println(" in chrome");
			System.setProperty("webdriver.chrome.driver", bdPath + "chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("ff")){
			System.out.println(" in gecko");
			System.setProperty("webdriver.gecko.driver", bdPath + "geckodriver.exe");	
			driver = new FirefoxDriver(); 
			
		}else if(browserName.equalsIgnoreCase("ie")){
        	System.setProperty("webdriver.ie.driver", bdPath + "IEDriverServer.exe");
        	System.out.println(" in IEDriverServer");
        	driver = new InternetExplorerDriver();
        	
        }
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("DRIVER.baseUrl"));	
		
	}
	
	
	
	
}
