package techskills.qa.hrs.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import techskills.qa.hrs.base.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver; 
	
	// By Locators
	private By email = By.id("loginEmail");
	private By pwd = By.id("password");
	private By showhidepwd = By.xpath("//i[contains(@class,\"eye\")]");
	private By forgotpwdlink = By.linkText("Forgot Password?");
	private By signinbtn = By.id("loginSubmitButton");
	private By footertext = By.xpath("//div[contains(@class,\"copyright\")]");
	private By healthrecoverysollink = By.linkText("Health Recovery Solutions");
	private By privacypolicy = By.linkText("Terms of Service and Privacy Policy");
	private By hrslogo = By.xpath("//img[@alt=\"HRS\"]");
	
	// By Locators Forgot Password
	private By forgotpwdtextbox = By.id("resetPassword_username");
	private By backbuttonBy = By.id("resetPasswordBackButton");
	private By submitbutton = By.id("resetPasswordSaveButton");
	private By pwdsubmittedsuccess= By.xpath("//span[@class=\"ng-scope\"]");
	
	
	// Constructor of the Page Class
	public LoginPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	// PageActions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public Boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotpwdlink).isDisplayed();
	}
	
	public Boolean isRecoverySolutionLinkExist() {
		return driver.findElement(healthrecoverysollink).isDisplayed();
	}
	
	
	public Boolean isShowHideSectionExist() {
		return driver.findElement(showhidepwd).isDisplayed();
	}
	
	public Boolean isSignInButtonExist() {
		return driver.findElement(signinbtn).isDisplayed();
	}
	
	public Boolean isHRSLogoExists() {
		return driver.findElement(hrslogo).isDisplayed();
	}
	
		

	public String doForgotPassword() {
		driver.findElement(forgotpwdlink).click();
		driver.findElement(forgotpwdtextbox).sendKeys("Test@test.com");
		driver.findElement(submitbutton).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pwdsubmittedsuccess));
		String message = driver.findElement(pwdsubmittedsuccess).getText();
		return message;
			
	}
	
	public String doRecoverySolutionlinkBehavior() {
		String parent = driver.getWindowHandle();
		driver.findElement(healthrecoverysollink).click();
		Set<String> S = driver.getWindowHandles();
		Iterator<String> it = S.iterator();
		while(it.hasNext())
		{
			String child_window = it.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				
				
			}
			
		}
		return driver.getTitle();
				
	}
	
}
