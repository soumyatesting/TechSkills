package techskills.qa.hrs.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browser) {
		System.out.println("The browser value is :"+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized--");
			options.merge(caps);
			driver = new ChromeDriver(options);
			
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			
		}
		else {
			System.out.println("Please pass the correct browser"+ browser);
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;	
	}
	
	/**
	 * 
	 * This method is used to load the properties 
	 * @return it return properties prop reference
	 */
	public Properties init_properties() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/techskills/qa/hrs/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		
	}

}

	

















