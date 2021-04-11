package techskills.qa.hrs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import techskills.qa.hrs.pages.LoginPage;

public class BaseTest {
	
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	
	@BeforeMethod
	
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browservalue = prop.getProperty("browser");
		driver = basepage.init_driver(browservalue);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	

}
